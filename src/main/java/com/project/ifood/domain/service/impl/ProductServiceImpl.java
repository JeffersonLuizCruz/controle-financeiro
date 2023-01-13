package com.project.ifood.domain.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.ifood.controller.dto.response.ProductResponseDTO;
import com.project.ifood.controller.mapper.ProductMapper;
import com.project.ifood.domain.model.Product;
import com.project.ifood.domain.model.Restaurant;
import com.project.ifood.domain.repositoy.ProductRepository;
import com.project.ifood.domain.service.ProductService;
import com.project.ifood.domain.service.RestaurantService;
import com.project.ifood.domain.service.exception.ConstraintViolationService;
import com.project.ifood.domain.service.exception.NotFoundExceptionService;

import lombok.RequiredArgsConstructor;

@Service @RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
	
	private final ProductRepository productRepository;
	private final RestaurantService restaurantService;
	private final ProductMapper productMapper;
	
	private final String CONSTRAINT_VALIDATION_MESSAGE = "Produto de código '%d' não pode ser removida, pois está em uso";
	private final String NOT_FOUND_MESSAGE = "Produto de código '%d' não encontrado.";
	
	
	@Transactional
	@Override
	public Product save(Product product) {
		return productRepository.save(product);
	}

	@Transactional
	@Override
	public Product update(Long id, Product product) {
		checkIfProductExists(id);
		
		product.setId(id);
		return productRepository.save(product);
	}

	@Override
	public Product findById(Long id) {
		return checkIfProductExists(id);
	}

	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public void deleteById(Long id) {

		try {
			Product productEntity = checkIfProductExists(id);
			productRepository.delete(productEntity);
			productRepository.flush();
		} catch (DataIntegrityViolationException | ConstraintViolationException e) {
			throw new ConstraintViolationService(String.format(CONSTRAINT_VALIDATION_MESSAGE, id));
		}
	}

	@Override
	public Product checkIfProductExists(Long id) {
		return productRepository.findById(id)
				.orElseThrow(() -> new NotFoundExceptionService(String.format(NOT_FOUND_MESSAGE, id)));
	}
	
	public ProductResponseDTO verifyIfExistRestaurantByProduct(Long restaurantId, Long productId) {
		Restaurant restaurant = restaurantService.checkIfRestaurantExists(restaurantId);
		
		List<ProductResponseDTO> listProductDTO = restaurant.getProducts().stream()
				.map(product -> productMapper.toDTO(product))
				.collect(Collectors.toList());

		ProductResponseDTO productDTO = listProductDTO.stream()
				.filter(p -> p.getId() == productId)
				.findFirst()
				.orElseThrow(() -> new ConstraintViolationService(String.format("Não existe um cadastro de produto com código %d para o restaurante de código %d", 
						productId, restaurantId)));
		return productDTO;
	}
}
