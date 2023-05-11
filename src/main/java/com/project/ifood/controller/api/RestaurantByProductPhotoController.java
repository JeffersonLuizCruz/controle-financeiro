package com.project.ifood.controller.api;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.ifood.controller.dto.request.ProductPhotoRequest;
import com.project.ifood.domain.model.Product;
import com.project.ifood.domain.model.ProductPhoto;
import com.project.ifood.domain.service.ProductPhotoService;
import com.project.ifood.domain.service.RestaurantByProductService;
import com.project.ifood.domain.service.exception.NotFoundExceptionService;
import com.project.ifood.infrastructure.service.FileStorageService;

@RestController
@RequestMapping("/restaurants/{restaurantId}/products/{productId}/photo")
public class RestaurantByProductPhotoController {

	@Autowired
	private RestaurantByProductService restaurantByProductService;
	@Autowired
	private ProductPhotoService productPhotoService;
	@Autowired
	private FileStorageService fileStorageService;

	@PutMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<ProductPhoto> updatePhoto(@PathVariable Long restaurantId, @PathVariable Long productId,
			@Valid ProductPhotoRequest ppr) throws SQLIntegrityConstraintViolationException, IOException {
		Product productEntity = restaurantByProductService.verifyIfExistRestaurantByProduct(restaurantId, productId);

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

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductPhoto> findByProductAndRestaurant(@PathVariable Long productId,
			@PathVariable Long restaurantId) {
		return ResponseEntity.ok(productPhotoService.findByProductAndRestaurant(productId, restaurantId));
	}

	@GetMapping
	public ResponseEntity<InputStreamResource> findByProductAndRestaurantFile(@PathVariable Long productId,
			@PathVariable Long restaurantId, @RequestHeader(name = "accept") String acceptHeaders) throws HttpMediaTypeNotAcceptableException {
		try {

			ProductPhoto pp = productPhotoService.findByProductAndRestaurant(productId, restaurantId);
			MediaType mediaType = MediaType.parseMediaType(pp.getContentType());
			List<MediaType> mediaTypes = MediaType.parseMediaTypes(acceptHeaders);
			checkCompatibilityMediaType(mediaType, mediaTypes);
			InputStream file = fileStorageService.getFile(pp.getFileName());
			
			return ResponseEntity.ok()
					.contentType(mediaType)
					.body(new InputStreamResource(file));
			
		} catch (NotFoundExceptionService e) {
			return ResponseEntity.notFound().build();
		}
	}

	private void checkCompatibilityMediaType(MediaType mediaType, List<MediaType> mediaTypes) throws HttpMediaTypeNotAcceptableException {
		boolean isMatch = mediaTypes.stream().anyMatch(any -> any.isCompatibleWith(mediaType));
		if(!isMatch) {
			throw new HttpMediaTypeNotAcceptableException(mediaTypes);
		}
		
	}
}
