package com.project.ifood.controller.dto.request;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import javax.persistence.Embedded;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.project.ifood.controller.dto.input.CustomerInput;
import com.project.ifood.controller.dto.input.PaymentMethodInput;
import com.project.ifood.controller.dto.input.RestaurantInput;
import com.project.ifood.domain.enums.OrderStatus;
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

	@Embedded
	private Address deliveryAddress;
	
	@Enumerated(EnumType.STRING)
	private OrderStatus status = OrderStatus.CREATED;

	private OffsetDateTime confirmationAt;
	private OffsetDateTime cancellationAt;
	private OffsetDateTime deliveryAt;
	
	private PaymentMethodInput paymentMethod;
	private RestaurantInput restaurant;
	private CustomerInput customer;
}
