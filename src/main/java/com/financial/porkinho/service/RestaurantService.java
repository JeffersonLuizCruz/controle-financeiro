package com.financial.porkinho.service;

import java.util.List;

import com.financial.porkinho.domain.model.Restaurant;

public interface RestaurantService {
	
	Restaurant save(Restaurant restaurant);
	Restaurant update(Long id, Restaurant restaurant);
	List<Restaurant> findAll();
	Restaurant findById(Long id);
	void delete(Long id);
}
