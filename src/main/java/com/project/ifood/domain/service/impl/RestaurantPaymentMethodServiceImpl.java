package com.project.ifood.domain.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.ifood.domain.model.PaymentMethod;
import com.project.ifood.domain.model.Restaurant;
import com.project.ifood.domain.service.PaymentMethodService;
import com.project.ifood.domain.service.RestaurantPaymentMethodService;
import com.project.ifood.domain.service.RestaurantService;

import lombok.RequiredArgsConstructor;

@Service @RequiredArgsConstructor
public class RestaurantPaymentMethodServiceImpl implements RestaurantPaymentMethodService{

	private final RestaurantService restaurantService;
	private final PaymentMethodService paymentMethodService;
	 
	
	@Transactional
	@Override
	public void disassociatePaymentMethod(Long restaurantId, Long paymentMethodId) {
		Restaurant restaurantEntity = restaurantService.checkIfRestaurantExists(restaurantId);
		PaymentMethod paymentMethodEntity = paymentMethodService.checkIfPaymentMethodExists(paymentMethodId);
		
		/**
		 * Não foi realizado um update explicito do jpa ainda assim foi feito o upadate. Isso porque
		 * a injeção de pedencia restaurantService e paymentMethodService junto com a anotação '@Transactional'
		 * está dentro do contexto do jpa.
		 * 
		 * */
		restaurantEntity.getPaymentMethods().remove(paymentMethodEntity);
	}


	@Transactional
	@Override
	public void associatePaymentMethod(Long restaurantId, Long paymentMethodId) {
		Restaurant restaurantEntity = restaurantService.checkIfRestaurantExists(restaurantId);
		PaymentMethod paymentMethodEntity = paymentMethodService.checkIfPaymentMethodExists(paymentMethodId);
		
		/**
		 * Não foi realizado um update explicito do jpa ainda assim foi feito o upadate. Isso porque
		 * a injeção de pedencia restaurantService e paymentMethodService junto com a anotação '@Transactional'
		 * está dentro do contexto do jpa.
		 * 
		 * */
		
		restaurantEntity.getPaymentMethods().add(paymentMethodEntity);
	}
}
