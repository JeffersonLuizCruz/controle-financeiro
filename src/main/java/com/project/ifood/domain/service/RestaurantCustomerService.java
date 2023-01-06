package com.project.ifood.domain.service;

public interface RestaurantCustomerService {
	
	void disassociate(Long restaurantId, Long customerId);
	void associate(Long restaurantId, Long customerId);
}
