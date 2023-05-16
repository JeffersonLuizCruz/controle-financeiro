package com.project.ifood.domain.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.ifood.domain.model.Order;
import com.project.ifood.domain.repositoy.OrderRepository;
import com.project.ifood.domain.service.OrderService;

import lombok.RequiredArgsConstructor;

@Service @RequiredArgsConstructor 
public class StatusOrderImpl {
	
	private final OrderService orderService;
	private final OrderRepository orderRepository;
	
	@Transactional
	public void created(String codeUUID) {
		Order orderEntity = orderService.findById(codeUUID);
		orderEntity.create();
	}
	
	@Transactional
	public void confirm(String codeUUID) {
		Order orderEntity = orderService.findById(codeUUID);
		orderEntity.confirm();
	
		orderRepository.save(orderEntity);
	}
	
	@Transactional
	public void delivery(String codeUUID) {
		Order orderEntity = orderService.findById(codeUUID);
		orderEntity.delivery();
	}
	
	@Transactional
	public void cancel(String codeUUID) {
		Order orderEntity = orderService.findById(codeUUID);
		orderEntity.cancel();
	}

}
