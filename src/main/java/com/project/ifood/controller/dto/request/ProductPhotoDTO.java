package com.project.ifood.controller.dto.request;

import javax.validation.constraints.NotBlank;

import org.springframework.web.multipart.MultipartFile;

import com.project.ifood.infrastructure.validation.FileSize;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class ProductPhotoDTO {

	@NotNull
	@FileSize(max = "50KB")
	private MultipartFile file;
	
	@NotBlank(message = "Nome obrigatório.")
	private String description;
}
