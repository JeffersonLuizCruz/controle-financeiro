package com.financial.ifood.service.impl;

import java.util.List;

import com.financial.ifood.service.exception.ConstraintViolationService;
import com.financial.ifood.service.exception.NotFoundExceptionService;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Service;

import com.financial.ifood.domain.model.Kitchen;
import com.financial.ifood.domain.model.Restaurant;
import com.financial.ifood.repository.RestaurantRepository;
import com.financial.ifood.service.KitchenService;
import com.financial.ifood.service.RestaurantService;

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

		try {
			restaurantRepository.delete(restaurantEntity);
		}catch (ConstraintViolationException e) {
			throw new ConstraintViolationService(String.format("TODO - Falta implementar"));
		}
	}
	
	@Override
	public Restaurant checkIfRestaurantExists(Long id) {
		return restaurantRepository.findById(id).orElseThrow(() -> new NotFoundExceptionService("") {
		});
	}

}
