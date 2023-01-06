package com.project.ifood.controller.api;

import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.project.ifood.domain.model.PaymentMethod;
import com.project.ifood.domain.model.Restaurant;
import com.project.ifood.domain.service.RestaurantPaymentMethodService;
import com.project.ifood.domain.service.RestaurantService;

import lombok.RequiredArgsConstructor;

@RestController @RequiredArgsConstructor
@RequestMapping("/restaurants/{restaurantId}/payment-methods")
public class RestaurantPaymentMethodController {

	private final RestaurantService restaurantService;
	private final RestaurantPaymentMethodService restaurantPaymentMethodService;
	
	@GetMapping
	public ResponseEntity<Set<PaymentMethod>> findByPaymentAll(@PathVariable Long restaurantId){
		Restaurant restaurantEntity = restaurantService.checkIfRestaurantExists(restaurantId);
		return ResponseEntity.ok(restaurantEntity.getPaymentMethods());
	}
	
	@DeleteMapping("/{paymentMethodId}") @ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void disassociatePaymentMethod(@PathVariable Long restaurantId,@PathVariable Long paymentMethodId) {
		restaurantPaymentMethodService.disassociatePaymentMethod(restaurantId, paymentMethodId);
	}
	
	@PutMapping("/{paymentMethodId}") @ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void associatePaymentMethod(@PathVariable Long restaurantId,@PathVariable Long paymentMethodId) {
		restaurantPaymentMethodService.associatePaymentMethod(restaurantId, paymentMethodId);
	}
}
