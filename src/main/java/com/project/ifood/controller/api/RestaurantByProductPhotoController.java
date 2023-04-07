package com.project.ifood.controller.api;

import java.io.IOException;
import java.nio.file.Path;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.ifood.controller.dto.request.ProductPhotoDTO;

@RestController
@RequestMapping("/restaurants/{restaurantId}/products/{productId}/photo")
public class RestaurantByProductPhotoController {

	@PutMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public void updatePhoto(@PathVariable Long restaurantId, @PathVariable Long productId, @Valid ProductPhotoDTO ppDto) {
		
		String fileName = UUID.randomUUID().toString() + "_" + ppDto.getFile().getOriginalFilename();
		Path path = Path.of("C:/Users/jlcruz/Desktop/category", fileName);
		
		try {
			ppDto.getFile().transferTo(path);
			System.out.println(ppDto.getDescription());
		} catch (IOException e) {
			throw new RuntimeException("Erro ao transferir o arquivo.");
		}
	}
}
