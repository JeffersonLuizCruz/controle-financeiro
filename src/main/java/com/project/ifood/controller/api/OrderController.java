package com.project.ifood.controller.api;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.ifood.controller.dto.response.OrderResponseDTO;
import com.project.ifood.controller.mapper.OrderMapper;
import com.project.ifood.domain.service.OrderService;

import lombok.RequiredArgsConstructor;

@RestController @RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

	private final OrderMapper orderMapper;
	private final OrderService orderService;
	
	@GetMapping
	public ResponseEntity<List<OrderResponseDTO>> findAll(){
		List<OrderResponseDTO> listOrderDTO = orderService.findAll()
		.stream()
		.map(order -> orderMapper.toDTO(order))
		.collect(Collectors.toList());
		
		return ResponseEntity.ok(listOrderDTO);
	}
}
