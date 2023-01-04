package com.project.ifood.api.controller.mapper.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
public class ProductResume {
	
	private String name;
	
	private String description;
	
	@PositiveOrZero
	private BigDecimal price;
	private Boolean isActive;
}
