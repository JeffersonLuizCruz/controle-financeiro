package com.financial.ifood.service;

import java.util.List;

import com.financial.ifood.domain.model.Restaurant;

public interface RestaurantService {
	
	Restaurant save(Restaurant restaurant);
	Restaurant update(Long id, Restaurant restaurant);
	List<Restaurant> findAll();
	Restaurant findById(Long id);
	void deleteById(Long id);
	Restaurant checkIfRestaurantExists(Long id);
}
