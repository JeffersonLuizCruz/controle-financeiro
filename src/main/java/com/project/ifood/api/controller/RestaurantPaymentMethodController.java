package com.project.ifood.api.controller;

import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.ifood.domain.model.PaymentMethod;
import com.project.ifood.domain.model.Restaurant;
import com.project.ifood.domain.service.RestaurantService;

import lombok.RequiredArgsConstructor;

@RestController @RequiredArgsConstructor
@RequestMapping("/restaurants/{restaurantId}/payment-methods")
public class RestaurantPaymentMethodController {

	private final RestaurantService restaurantService;
	
	@GetMapping
	public ResponseEntity<Set<PaymentMethod>> findById(@PathVariable Long restaurantId){
		Restaurant restaurantEntity = restaurantService.checkIfRestaurantExists(restaurantId);
		return ResponseEntity.ok(restaurantEntity.getPaymentMethods());
	}
}
