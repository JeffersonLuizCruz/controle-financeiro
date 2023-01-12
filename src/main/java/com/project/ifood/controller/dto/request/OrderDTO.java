package com.project.ifood.controller.dto.request;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import javax.validation.Valid;

import com.project.ifood.controller.dto.input.CustomerInput;
import com.project.ifood.controller.dto.input.PaymentMethodInput;
import com.project.ifood.controller.dto.input.RestaurantInput;
import com.project.ifood.domain.model.Address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
public class OrderDTO {

	private String code;
	private BigDecimal subtotal;
	private BigDecimal freightRate;
	private BigDecimal totalAmount;

	private Address deliveryAddress;
	
	private String status;

	private OffsetDateTime confirmationAt;
	private OffsetDateTime cancellationAt;
	private OffsetDateTime deliveryAt;
	
	@Valid
	private PaymentMethodInput paymentMethod;
	
	@Valid
	private RestaurantInput restaurant;
	
	@Valid
	private CustomerInput customer;
	
	//private List<Ord>
}
