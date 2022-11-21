package com.financial.porkinho.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.financial.porkinho.domain.model.Kitchen;
import com.financial.porkinho.domain.model.Restaurant;
import com.financial.porkinho.repository.RestaurantRepository;
import com.financial.porkinho.service.KitchenService;
import com.financial.porkinho.service.RestaurantService;

@Service
public class RestaurantServiceImpl implements RestaurantService{

	private final RestaurantRepository restaurantRepository;
	private final KitchenService kitchenService;
	
	public RestaurantServiceImpl(RestaurantRepository restaurantRepository, KitchenService kitchenService) {
		this.restaurantRepository = restaurantRepository;
		this.kitchenService = kitchenService;
	}

	@Override
	public Restaurant save(Restaurant restaurant) {
		Kitchen kitchenEntity = kitchenService.findById(restaurant.getKitchen().getId());
		restaurant.setKitchen(kitchenEntity);
		
		return restaurantRepository.save(restaurant);
	}

	@Override
	public Restaurant update(Long id, Restaurant restaurant) {
		Restaurant restaurantEntity = checkIfRestaurantExists(id);
		kitchenService.checkIfKitchenExists(restaurant.getKitchen().getId());
		
		restaurant.setId(id);
		restaurant.setCreateAt(restaurantEntity.getCreateAt());
		restaurant.setKitchen(restaurant.getKitchen());
		
		return restaurantRepository.save(restaurant);
	}

	@Override
	public List<Restaurant> findAll() {
		return restaurantRepository.findAll();
	}

	@Override
	public Restaurant findById(Long id) {
		return checkIfRestaurantExists(id);
	}

	@Override
	public void deleteById(Long id) {
		Restaurant restaurantEntity = checkIfRestaurantExists(id);
		restaurantRepository.delete(restaurantEntity);
	}
	
	@Override
	public Restaurant checkIfRestaurantExists(Long id) {
		return restaurantRepository.findById(id).orElseThrow(() -> new RuntimeException("TODO - Implement exception Handler"));
	}

}
