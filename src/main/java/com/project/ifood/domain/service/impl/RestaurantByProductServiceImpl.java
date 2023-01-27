package com.project.ifood.domain.service.impl;

import org.springframework.stereotype.Service;

import com.project.ifood.controller.dto.request.ProductDTO;
import com.project.ifood.controller.dto.response.ProductResponseDTO;
import com.project.ifood.controller.mapper.ProductMapper;
import com.project.ifood.domain.model.Product;
import com.project.ifood.domain.model.Restaurant;
import com.project.ifood.domain.service.ProductService;
import com.project.ifood.domain.service.RestaurantByProductService;
import com.project.ifood.domain.service.RestaurantService;
import com.project.ifood.domain.service.exception.BadRequestExcertpionService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RestaurantByProductServiceImpl implements RestaurantByProductService {

	private final RestaurantService restaurantService;
	private final ProductService productService;
	private final ProductMapper productMapper;

	@Override
	public Product saveRestaurantByProduct(Long restaurantId, ProductDTO dto) {
		Restaurant restaurantEntity = restaurantService.checkIfRestaurantExists(restaurantId);

		Product modelProduct = productMapper.toModel(dto);
		modelProduct.setRestaurant(restaurantEntity);

		Product productEntity = productService.save(modelProduct);
		return productEntity;
	}

	@Override
	public ProductResponseDTO verifyIfExistRestaurantByProduct(Long restaurantId, Long productId) {
		Restaurant restaurantEntity = restaurantService.checkIfRestaurantExists(restaurantId);

		ProductResponseDTO productResponse = restaurantEntity.getProducts()
				.stream()
				.map(product -> productMapper.toDTO(product))
				.filter(p -> p.getId() == productId)
				.findFirst()
				.orElseThrow(() -> new BadRequestExcertpionService(
						String.format("Não existe um cadastro de produto com código %d para o restaurante de código %d",
								productId, restaurantId)));

		return productResponse;
	}

}
