package com.project.ifood.domain.service.impl;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.stereotype.Service;

import com.project.ifood.domain.model.Kitchen;
import com.project.ifood.domain.model.Restaurant;
import com.project.ifood.domain.repositoy.RestaurantRepository;
import com.project.ifood.domain.service.KitchenService;
import com.project.ifood.domain.service.RestaurantService;
import com.project.ifood.domain.service.exception.ConstraintViolationService;
import com.project.ifood.domain.service.exception.NotFoundExceptionService;

@Service
public class RestaurantServiceImpl implements RestaurantService{

	private final RestaurantRepository restaurantRepository;
	private final KitchenService kitchenService;
	
	public RestaurantServiceImpl(RestaurantRepository restaurantRepository, KitchenService kitchenService) {
		this.restaurantRepository = restaurantRepository;
		this.kitchenService = kitchenService;
	}


	private final String CONSTRAINT_VALIDATION_MESSAGE = "Restaurante de código '%d' não pode ser removida, pois está em uso";
	private final String NOT_FOUND_MESSAGE = "Restaurante de código '%d' não encontrado.";

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

		try {
			Restaurant restaurantEntity = checkIfRestaurantExists(id);
			restaurantRepository.delete(restaurantEntity);
		}catch (ConstraintViolationException e) {
			throw new ConstraintViolationService(String.format(CONSTRAINT_VALIDATION_MESSAGE, id));
		}
	}
	
	@Override
	public Restaurant checkIfRestaurantExists(Long id) {
		return restaurantRepository.findById(id).orElseThrow(() ->
				new NotFoundExceptionService(String.format(NOT_FOUND_MESSAGE, id)));
	}

}
