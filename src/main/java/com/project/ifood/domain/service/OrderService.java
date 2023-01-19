package com.project.ifood.domain.service;

import java.util.List;

import com.project.ifood.domain.model.Order;

public interface OrderService {

	Order save(Order order);
	Order update(String codeUUID, Order order);
	List<Order> findAll();
	Order findById(String codeUUID);
	void deleteById(String codeUUID);
	Order checkIfOrderExists(String codeUUID);
}
