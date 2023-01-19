package com.project.ifood.domain.enums;

import java.util.Arrays;
import java.util.List;

import lombok.Getter;

public enum OrderStatus {
	CREATED("Criado"),
	CONFIRMED("Confirmado", CREATED),
	DELIVERED("Enviado", CONFIRMED),
	CANCELLED("Cancelado", CREATED);
	
	@Getter
	private String description;
	
	@Getter
	private List<OrderStatus> beforeStatus;
	
	OrderStatus(String description, OrderStatus... beforeStatus){
		this.description = description;
		this.beforeStatus = Arrays.asList(beforeStatus);
	}
	
	
	public boolean cannotChangeTo(OrderStatus newStatus) {
		return !newStatus.getBeforeStatus().contains(this);
	}
}
