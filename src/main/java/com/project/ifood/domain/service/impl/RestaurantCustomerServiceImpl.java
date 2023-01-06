package com.project.ifood.domain.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.ifood.domain.model.Customer;
import com.project.ifood.domain.model.Restaurant;
import com.project.ifood.domain.service.CustomerService;
import com.project.ifood.domain.service.RestaurantCustomerService;
import com.project.ifood.domain.service.RestaurantService;

import lombok.RequiredArgsConstructor;

@Service @RequiredArgsConstructor
public class RestaurantCustomerServiceImpl implements RestaurantCustomerService{

	private final RestaurantService restaurantService;
	private final CustomerService customerService;
	
	@Transactional
	@Override
	public void disassociate(Long restaurantId, Long customerId) {
		Restaurant restaurantEntity = restaurantService.checkIfRestaurantExists(restaurantId);
		Customer customerEntity = customerService.checkIfCustomerExists(customerId);
		
		restaurantEntity.getOwner().remove(customerEntity);
		
	}

	@Transactional
	@Override
	public void associate(Long restaurantId, Long customerId) {
		Restaurant restaurantEntity = restaurantService.checkIfRestaurantExists(restaurantId);
		Customer customerEntity = customerService.checkIfCustomerExists(customerId);
		
		restaurantEntity.getOwner().add(customerEntity);
		
	}

}
