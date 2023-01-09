package com.project.ifood.domain.service.impl;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.ifood.domain.model.Customer;
import com.project.ifood.domain.model.Order;
import com.project.ifood.domain.model.PaymentMethod;
import com.project.ifood.domain.model.Restaurant;
import com.project.ifood.domain.repositoy.OrderRepository;
import com.project.ifood.domain.service.CustomerService;
import com.project.ifood.domain.service.OrderService;
import com.project.ifood.domain.service.PaymentMethodService;
import com.project.ifood.domain.service.RestaurantService;
import com.project.ifood.domain.service.exception.ConstraintViolationService;
import com.project.ifood.domain.service.exception.NotFoundExceptionService;

import lombok.RequiredArgsConstructor;

@Service @RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

	private final OrderRepository orderRepository;
	private final PaymentMethodService paymentMethodService;
	private final RestaurantService restaurantService;
	private final CustomerService customerService;
	
	
    private final String CONSTRAINT_VALIDATION_MESSAGE = "Pedido de código '%d' não pode ser removida, pois está em uso";
    private final String NOT_FOUND_MESSAGE = "Pedido de código '%d' não encontrado.";
    
    @Transactional
	@Override
	public Order save(Order order) {
    	PaymentMethod paymentMethodEntity = paymentMethodService.findById(order.getPaymentMethod().getId());
    	Restaurant restaurantEntity = restaurantService.findById(order.getRestaurant().getId());
    	Customer customerEntity = customerService.findById(order.getCustomer().getId());
    	
    	order.setPaymentMethod(paymentMethodEntity);
    	order.setRestaurant(restaurantEntity);
    	order.setCustomer(customerEntity);
    	
		return orderRepository.save(order);
	}

    @Transactional
	@Override
	public Order update(Long id, Order order) {
    	checkIfOrderExists(id);
    	PaymentMethod paymentMethodEntity = paymentMethodService.checkIfPaymentMethodExists(order.getPaymentMethod().getId());
    	Restaurant restaurantEntity = restaurantService.checkIfRestaurantExists(order.getRestaurant().getId());
    	Customer customerEntity = customerService.checkIfCustomerExists(order.getCustomer().getId());
    	
    	order.setId(id);
    	order.setPaymentMethod(paymentMethodEntity);
    	order.setRestaurant(restaurantEntity);
    	order.setCustomer(customerEntity);
    	
		return orderRepository.save(order);
	}

	@Override
	public List<Order> findAll() {
		return orderRepository.findAll();
	}

	@Override
	public Order findById(Long id) {
		return checkIfOrderExists(id);
	}

	@Transactional
	@Override
	public void deleteById(Long id) {
		try {
			Order orderEntity = checkIfOrderExists(id);
			orderRepository.delete(orderEntity);
			orderRepository.flush();
		}catch (DataIntegrityViolationException | ConstraintViolationException e){
			throw new ConstraintViolationService(String.format(CONSTRAINT_VALIDATION_MESSAGE, id));
		}
		
	}

	@Override
	public Order checkIfOrderExists(Long id) {
        return orderRepository.findById(id).orElseThrow(() ->
        new NotFoundExceptionService(String.format(NOT_FOUND_MESSAGE, id)));
	}

}
