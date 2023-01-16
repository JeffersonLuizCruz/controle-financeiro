package com.project.ifood.controller.dto.resume;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import com.project.ifood.controller.dto.input.ProductInputById;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor @Data
public class OrderItemResume {
	
	@NotNull
	@PositiveOrZero
	private Integer quantity;
	private String observation;

	@Valid
	@NotNull
	private ProductInputById product;
}
