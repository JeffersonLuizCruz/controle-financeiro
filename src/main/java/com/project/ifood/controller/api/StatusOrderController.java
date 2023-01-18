package com.project.ifood.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.project.ifood.domain.service.impl.StatusOrderImpl;

import lombok.RequiredArgsConstructor;

@RestController @RequiredArgsConstructor
@RequestMapping("/orders/{orderId}")
public class StatusOrderController {
	
	private final StatusOrderImpl statusOrder;
	
	@PutMapping("/confirm") @ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void statusConfirm(@PathVariable Long orderId) {
		statusOrder.confirm(orderId);
	}

}
