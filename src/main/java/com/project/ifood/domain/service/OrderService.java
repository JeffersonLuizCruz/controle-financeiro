package com.project.ifood.domain.service;

import java.util.List;

import com.project.ifood.domain.model.Order;

public interface OrderService {

	Order save(Order order);
	Order update(Long id, Order order);
	List<Order> findAll();
	Order findById(Long id);
	void deleteById(Long id);
	Order checkIfOrderExists(Long id);
}
