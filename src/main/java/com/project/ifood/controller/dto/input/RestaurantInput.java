package com.project.ifood.controller.dto.input;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor @Data
public class RestaurantInput {

	@NotNull(message = "Restaurante é obrigatório!")
	public Long id;
}
