package com.project.ifood.api.controller.mapper.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
public class ProductResume {
	
	@NotBlank(message = "Nome do produto obrigatório")
	private String name;
	
	@NotBlank(message = "Descrição do produto obrigatório")
	private String description;
	
	@NotNull
	@PositiveOrZero
	private BigDecimal price;
	private Boolean isActive;
}
