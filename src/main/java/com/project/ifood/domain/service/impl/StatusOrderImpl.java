package com.project.ifood.domain.service.impl;

import java.time.OffsetDateTime;

import org.springframework.stereotype.Service;

import com.project.ifood.domain.enums.OrderStatus;
import com.project.ifood.domain.model.Order;
import com.project.ifood.domain.service.OrderService;
import com.project.ifood.domain.service.exception.ConstraintViolationService;

import lombok.RequiredArgsConstructor;

@Service @RequiredArgsConstructor 
public class StatusOrderImpl {
	
	private final OrderService orderService;
	
	public void confirm(Long orderId) {
		Order orderEntity = orderService.findById(orderId);
		
		if(!orderEntity.getStatus().equals(OrderStatus.CREATED)) {
			throw new ConstraintViolationService(
					String.format("Status do pedido %d não pode ser alterado de %s para %s",
							orderEntity.getId(), orderEntity.getStatus().getDescription(), OrderStatus.CONFIRMED.getDescription()));
		}
		
		orderEntity.setStatus(OrderStatus.CONFIRMED);
		orderEntity.setConfirmationAt(OffsetDateTime.now());
	}

}
