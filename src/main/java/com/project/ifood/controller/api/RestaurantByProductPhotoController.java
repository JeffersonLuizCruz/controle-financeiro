package com.project.ifood.controller.api;

import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.ifood.controller.dto.request.ProductPhotoRequest;
import com.project.ifood.domain.model.Product;
import com.project.ifood.domain.model.ProductPhoto;
import com.project.ifood.domain.service.ProductPhotoService;
import com.project.ifood.domain.service.RestaurantByProductService;
import com.project.ifood.infrastructure.service.FileStorageService;

@RestController
@RequestMapping("/restaurants/{restaurantId}/products/{productId}/photo")
public class RestaurantByProductPhotoController {

	@Autowired private RestaurantByProductService restaurantByProductService;
	@Autowired private ProductPhotoService productPhotoService;
	//@Autowired private ProductRepository productRepository;
	@Autowired private FileStorageService fileStorageService;
	
	@PutMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<ProductPhoto> updatePhoto(@PathVariable Long restaurantId, @PathVariable Long productId, @Valid ProductPhotoRequest ppr) throws SQLIntegrityConstraintViolationException, IOException {
		Product productEntity = restaurantByProductService.verifyIfExistRestaurantByProduct(restaurantId, productId);
		//Product product = productRepository.findByIdLazy(productEntity.getId()).get();
		
		ProductPhoto pp = new ProductPhoto();
		pp.setContentType(ppr.getFile().getContentType());
		pp.setDescription(ppr.getDescription());
		pp.setFileName(UUID.randomUUID() + "_" + ppr.getFile().getOriginalFilename());
		pp.setSize(String.valueOf(ppr.getFile().getSize()));
		pp.setProduct(productEntity);
		
		pp = productPhotoService.save(pp);
		fileStorageService.storage(ppr.getFile().getInputStream(), pp.getFileName());
		return ResponseEntity.ok(pp);

	}
	
	@GetMapping
	public ResponseEntity<ProductPhoto> findByProductAndRestaurant(@PathVariable Long productId, @PathVariable Long restaurantId){
		return ResponseEntity.ok(productPhotoService.findByProductAndRestaurant(productId, restaurantId));
	}
}
