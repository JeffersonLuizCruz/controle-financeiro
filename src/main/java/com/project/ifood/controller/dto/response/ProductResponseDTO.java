package com.project.ifood.controller.dto.response;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
public class ProductResponseDTO {

	private Long id;
	private String name;
	private String description;
	private BigDecimal price;
	private Boolean isActive;
}
