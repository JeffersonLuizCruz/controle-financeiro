package com.project.ifood.controller.dto.response;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.project.ifood.controller.dto.resume.CustomerResume;
import com.project.ifood.controller.dto.resume.PaymentMethodResume;
import com.project.ifood.controller.dto.resume.RestaurantResume;
import com.project.ifood.domain.enums.OrderStatus;
import com.project.ifood.domain.model.Address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor @Data
public class OrderResponseDTO {

	private Long id;
	private String code;
	private BigDecimal subtotal;
	private BigDecimal freightRate;
	private BigDecimal totalAmount;
	private Address deliveryAddress;
	private OrderStatus status = OrderStatus.CREATED;
	
	private OffsetDateTime confirmationAt;
	private OffsetDateTime cancellationAt;
	private OffsetDateTime deliveryAt;
	
	private PaymentMethodResume paymentMethod;
	private RestaurantResume restaurant;
	private CustomerResume customer;
}
