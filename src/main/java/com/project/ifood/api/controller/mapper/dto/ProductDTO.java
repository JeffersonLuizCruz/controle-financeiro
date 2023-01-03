package com.project.ifood.api.controller.mapper.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
public class ProductDTO {
	
	@NotBlank(message = "Nome do produto obrigatório")
	private String name;
	private String description;
	
	@NotBlank(message = "Preço do produto obrigatório")
	private BigDecimal price;
	private Boolean isActive;
}
