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
@RequestMapping(value = "/orders/{codeUUID}")
public class StatusOrderController {
	
	private final StatusOrderImpl statusOrder;
	
	
	@PutMapping("/create") @ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void statusCreate(@PathVariable String codeUUID) {
		statusOrder.cancel(codeUUID);
	}
	
	@PutMapping("/confirm") @ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void statusConfirm(@PathVariable String codeUUID) {
		statusOrder.confirm(codeUUID);
	}
	
	@PutMapping("/deliver") @ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void statusDeliver(@PathVariable String codeUUID) {
		statusOrder.delivery(codeUUID);
	}
	
	@PutMapping("/cancel") @ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void statusCancel(@PathVariable String codeUUID) {
		statusOrder.cancel(codeUUID);
	}

}
