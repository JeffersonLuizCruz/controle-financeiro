package com.project.ifood.domain.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.ifood.domain.model.Order;
import com.project.ifood.domain.service.OrderService;
import com.project.ifood.infrastructure.service.SendMailService;
import com.project.ifood.infrastructure.service.SendMailService.Message;

import lombok.RequiredArgsConstructor;

@Service @RequiredArgsConstructor 
public class StatusOrderImpl {
	
	private final OrderService orderService;
	private final SendMailService sendMailService;
	
	@Transactional
	public void created(String codeUUID) {
		Order orderEntity = orderService.findById(codeUUID);
		orderEntity.create();
	}
	
	@Transactional
	public void confirm(String codeUUID) {
		Order orderEntity = orderService.findById(codeUUID);
		orderEntity.confirm();
		
		Message message = Message.builder()
		.subject("Pedido " + orderEntity.getCode() + "confirmado com sucesso!")
		.recipient(orderEntity.getCustomer().getEmail())
		.body("Pedido confirmado com sucesso. Código do pedido: " + orderEntity.getCode())
		.build();
		
		sendMailService.send(message);
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
