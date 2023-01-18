package com.project.ifood.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum OrderStatus {
	CREATED("Criado"),
	DELIVERED("Enviado"),
	CONFIRMED("Confirmado"),
	CANCELLED("Cancelado");
	
	@Getter
	private String description;
}
