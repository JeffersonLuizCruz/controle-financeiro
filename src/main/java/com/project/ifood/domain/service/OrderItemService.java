package com.project.ifood.domain.service;

import java.util.List;

import com.project.ifood.domain.model.OrderItem;

public interface OrderItemService {

	OrderItem save(OrderItem orderItem);
	OrderItem update(Long id, OrderItem orderItem);
	List<OrderItem> findAll();
	OrderItem findById(Long id);
	void deleteById(Long id);
	OrderItem checkIfOrderItemExists(Long id);
}
