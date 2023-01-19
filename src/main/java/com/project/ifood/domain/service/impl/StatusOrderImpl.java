package com.project.ifood.domain.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.ifood.domain.model.Order;
import com.project.ifood.domain.service.OrderService;

import lombok.RequiredArgsConstructor;

@Service @RequiredArgsConstructor 
public class StatusOrderImpl {
	
	private final OrderService orderService;
	
	@Transactional
	public void created(Long orderId) {
		Order orderEntity = orderService.findById(orderId);
		orderEntity.create();
	}
	
	@Transactional
	public void confirm(Long orderId) {
		Order orderEntity = orderService.findById(orderId);
		orderEntity.confirm();
	}
	
	@Transactional
	public void delivery(Long orderId) {
		Order orderEntity = orderService.findById(orderId);
		orderEntity.delivery();
	}
	
	@Transactional
	public void cancel(Long orderId) {
		Order orderEntity = orderService.findById(orderId);
		orderEntity.cancel();
	}

}
