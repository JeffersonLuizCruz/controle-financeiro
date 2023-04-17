package com.project.ifood.controller.dto.request;

import javax.validation.constraints.NotBlank;

import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;

import com.project.ifood.infrastructure.validation.FileContentType;
import com.project.ifood.infrastructure.validation.FileSize;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class ProductPhotoDTO {

	@NotNull
	@FileSize(max = "100KB") // Anotation Personalizada
	@FileContentType(allowed = { MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE }) // Anotation Personalizada
	private MultipartFile file;
	
	@NotBlank(message = "Nome obrigatório.")
	private String description;
}
