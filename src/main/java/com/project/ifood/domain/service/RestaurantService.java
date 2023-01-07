package com.project.ifood.domain.service;

import java.util.List;

import com.project.ifood.domain.model.Restaurant;

public interface RestaurantService {
	
	Restaurant save(Restaurant restaurant);
	Restaurant update(Long id, Restaurant restaurant);
	List<Restaurant> findAll();
	Restaurant findById(Long id);
	void deleteById(Long id);
	Restaurant checkIfRestaurantExists(Long id);
	void isActive(Long id);
	void isInactive(Long id);
	void isOpen(Long id);
	void isClosed(Long id);
	void inactiveAll(List<Long> ids);
	void activeAll(List<Long> ids);
}