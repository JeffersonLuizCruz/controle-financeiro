package com.project.ifood.controller.api;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.ifood.controller.dto.request.ProductPhotoDTO;
import com.project.ifood.controller.dto.response.ProductResponseDTO;
import com.project.ifood.domain.model.Product;
import com.project.ifood.domain.model.ProductPhoto;
import com.project.ifood.domain.repositoy.ProductRepository;
import com.project.ifood.domain.service.ProductPhotoService;
import com.project.ifood.domain.service.RestaurantByProductService;

@RestController
@RequestMapping("/restaurants/{restaurantId}/products/{productId}/photo")
public class RestaurantByProductPhotoController {

	@Autowired private RestaurantByProductService restaurantByProductService;
	@Autowired private ProductPhotoService productPhotoService;
	@Autowired private ProductRepository productRepository;
	
	@PutMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public void updatePhoto(@PathVariable Long restaurantId, @PathVariable Long productId, @Valid ProductPhotoDTO ppDto) throws SQLIntegrityConstraintViolationException {
		ProductResponseDTO productDto = restaurantByProductService.verifyIfExistRestaurantByProduct(restaurantId, productId);
		Product product = productRepository.findByIdLazy(productDto.getId()).get();
		
		ProductPhoto pp = new ProductPhoto();
		pp.setContentType(ppDto.getFile().getContentType());
		pp.setDescription(ppDto.getDescription());
		pp.setFileName(ppDto.getFile().getOriginalFilename());
		pp.setSize(String.valueOf(ppDto.getFile().getSize()));
		pp.setProduct(product);
		
		try {
			productPhotoService.save(pp);
			// Salva o arquivo temporariamente
			Path tempFilePath = Files.createTempFile("product-photo-", ".tmp");
			ppDto.getFile().transferTo(tempFilePath.toFile());
			Path finalFilePath = Path.of("C:/Users/jlcruz/Desktop/Teste/" + ppDto.getFile().getOriginalFilename());
			Files.move(tempFilePath, finalFilePath, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException | UncheckedIOException e) {
			throw new RuntimeException("Alerta: arquivo removido");
		} catch (Exception e) {
			throw new RuntimeException("Erro ao mover o arquivo: " + e.getMessage());
		}
		
	}
}
