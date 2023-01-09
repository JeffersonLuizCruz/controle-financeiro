package com.project.ifood.controller.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.ifood.controller.mapper.OrderMapper;

import lombok.RequiredArgsConstructor;

@RestController @RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

	private final OrderMapper orderMapper;
	
	//TODO - concluir implementação dos métodos
}
