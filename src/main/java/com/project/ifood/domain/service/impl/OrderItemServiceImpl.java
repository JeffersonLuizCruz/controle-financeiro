package com.project.ifood.domain.service.impl;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.project.ifood.domain.model.OrderItem;
import com.project.ifood.domain.repositoy.OrderItemRepository;
import com.project.ifood.domain.service.OrderItemService;
import com.project.ifood.domain.service.exception.ConstraintViolationService;
import com.project.ifood.domain.service.exception.NotFoundExceptionService;

import lombok.RequiredArgsConstructor;

@Service @RequiredArgsConstructor
public class OrderItemServiceImpl implements OrderItemService{

	private final OrderItemRepository orderItemRepository;
	
	
    private final String CONSTRAINT_VALIDATION_MESSAGE = "Item do Pedido de código '%d' não pode ser removida, pois está em uso";
    private final String NOT_FOUND_MESSAGE = "Item do Pedido de código '%d' não encontrado.";
    
	@Override
	public OrderItem save(OrderItem orderItem) {
		
		orderItem.setUnitPrice(orderItem.getProduct().getPrice());
		
		return orderItemRepository.save(orderItem);
	}

	@Override
	public OrderItem update(Long id, OrderItem orderItem) {
		
		return null;
	}

	@Override
	public List<OrderItem> findAll() {
		
		return null;
	}

	@Override
	public OrderItem findById(Long id) {
		return checkIfOrderItemExists(id);
	}

	@Override
	public void deleteById(Long id) {
		try {
			OrderItem orderItem = checkIfOrderItemExists(id);
			orderItemRepository.delete(orderItem);
			orderItemRepository.flush();
		}catch (DataIntegrityViolationException | ConstraintViolationException e){
			throw new ConstraintViolationService(String.format(CONSTRAINT_VALIDATION_MESSAGE, id));
		}
		
	}

	@Override
	public OrderItem checkIfOrderItemExists(Long id) {
		return orderItemRepository.findById(id)
				.orElseThrow(() -> new NotFoundExceptionService(String.format(NOT_FOUND_MESSAGE, id)));
	}
	
}
