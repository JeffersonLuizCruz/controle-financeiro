package com.project.ifood.domain.service;

public interface RestaurantPaymentMethodService {
	void disassociatePaymentMethod(Long restaurantId, Long paymentMethodId);
	void associatePaymentMethod(Long restaurantId, Long paymentMethodId);
}
