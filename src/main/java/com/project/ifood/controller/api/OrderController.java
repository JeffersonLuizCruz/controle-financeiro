package com.project.ifood.controller.api;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.ifood.controller.dto.request.OrderDTO;
import com.project.ifood.controller.dto.response.OrderResponseDTO;
import com.project.ifood.controller.mapper.OrderMapper;
import com.project.ifood.domain.model.Order;
import com.project.ifood.domain.service.OrderService;

import lombok.RequiredArgsConstructor;

@RestController @RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

	private final OrderMapper orderMapper;
	private final OrderService orderService;
	
	
	@PostMapping
	public ResponseEntity<OrderResponseDTO> save(@RequestBody @Valid OrderDTO dto){
		Order modelOrder = orderMapper.toModel(dto);
		Order orderEntity = orderService.save(modelOrder);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(orderMapper.toDTO(orderEntity));
	}
	
	@PostMapping("/{id}")
	public ResponseEntity<OrderResponseDTO> save(@PathVariable Long id, @RequestBody @Valid OrderDTO dto){
		Order modelOrder = orderMapper.toModel(dto);
		Order orderEntity = orderService.update(id, modelOrder);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(orderMapper.toDTO(orderEntity));
	}
	
	@GetMapping
	public ResponseEntity<List<OrderResponseDTO>> findAll(){
		List<OrderResponseDTO> listOrderDTO = orderService.findAll()
		.stream()
		.map(order -> orderMapper.toDTO(order))
		.collect(Collectors.toList());
		
		return ResponseEntity.ok(listOrderDTO);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<OrderResponseDTO> findById(@PathVariable Long id){
		Order orderEntity = orderService.findById(id);
		
		return ResponseEntity.ok(orderMapper.toDTO(orderEntity));
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		orderService.deleteById(id);
	}
}
