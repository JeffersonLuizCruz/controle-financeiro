package com.project.ifood.controller.dto.resume;

import com.project.ifood.controller.dto.input.ProductInput;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor @Data
public class OrderItemResume {
	
	private Long id;
	private Integer quantity;
	private String observation;

	private ProductInput product;
}
