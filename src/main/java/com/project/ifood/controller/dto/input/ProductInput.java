package com.project.ifood.controller.dto.input;

import lombok.Data;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
public class ProductInput {

	@NotNull(message = "Produto é obrigatório!")
	private Long id;
}
