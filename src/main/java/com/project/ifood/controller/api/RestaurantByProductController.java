package com.project.ifood.controller.api;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.ifood.controller.dto.request.ProductDTO;
import com.project.ifood.controller.dto.response.ProductResponseDTO;
import com.project.ifood.controller.mapper.ProductMapper;
import com.project.ifood.domain.model.Product;
import com.project.ifood.domain.model.Restaurant;
import com.project.ifood.domain.repositoy.ProductRepository;
import com.project.ifood.domain.service.ProductService;
import com.project.ifood.domain.service.RestaurantByProductService;
import com.project.ifood.domain.service.RestaurantService;

import lombok.RequiredArgsConstructor;

@RestController @RequiredArgsConstructor
@RequestMapping("/restaurants/{restaurantId}/products")
public class RestaurantByProductController {

	private final RestaurantService restaurantService;
	private final ProductService productService;
	private final ProductRepository productRepository;
	private final ProductMapper productMapper;
	private final RestaurantByProductService restaurantByProductService;

	@PostMapping
	public ResponseEntity<ProductResponseDTO> save(@PathVariable Long restaurantId, @RequestBody @Valid ProductDTO dto){
		Product productEntity = restaurantByProductService.saveRestaurantByProduct(restaurantId, dto);

		return ResponseEntity.status(HttpStatus.CREATED).body(productMapper.toDTO(productEntity));
	}
	
	@PutMapping("/{productId}")
	public ResponseEntity<ProductResponseDTO> update(@PathVariable Long restaurantId,@PathVariable Long productId, @RequestBody @Valid ProductDTO dto){
		Restaurant restaurantEntity = restaurantService.checkIfRestaurantExists(restaurantId);

		Product modelProduct = productMapper.toModel(dto);
		modelProduct.setRestaurant(restaurantEntity);
		
		Product productEntity = productService.update(productId, modelProduct);
		return ResponseEntity.ok(productMapper.toDTO(productEntity));
	}
	
	@GetMapping
	public ResponseEntity<List<ProductResponseDTO>> findByProductsAll(@PathVariable Long restaurantId) {

		Restaurant restaurant = restaurantService.checkIfRestaurantExists(restaurantId);
		List<Product> listProductEntity = productRepository.findByRestaurant(restaurant);
		
		List<ProductResponseDTO> listProductDTO = listProductEntity.stream()
		.map(product -> productMapper.toDTO(product))
		.collect(Collectors.toList());
		
		return ResponseEntity.ok(listProductDTO);
	}
	
	@GetMapping("/{productId}")
	public ResponseEntity<ProductResponseDTO> findByProduct(@PathVariable Long restaurantId, @PathVariable Long productId) {
		
		/***
		 * Exemplo simplificado de implementação do método:
		 * 
		 * 	Optional<Product> productOptional = productRepository.findByIdProduct(restaurantId, productId);
		 *	if(!productOptional.isPresent()) throw new ConstraintViolationService("Objeto não encontrado");
		 *
		 *	return ResponseEntity.ok(productMapper.toDTO(productOptional.get()));
		 *	 
		 * */
		
		ProductResponseDTO productDTO = restaurantByProductService.verifyIfExistRestaurantByProduct(restaurantId, productId);
		
		return ResponseEntity.ok(productDTO);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		productService.deleteById(id);
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
}
