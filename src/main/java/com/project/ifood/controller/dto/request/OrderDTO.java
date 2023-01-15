package com.project.ifood.controller.dto.request;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.project.ifood.controller.dto.input.PaymentMethodInput;
import com.project.ifood.controller.dto.input.RestaurantInput;
import com.project.ifood.controller.dto.resume.OrderItemResume;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
public class OrderDTO {
	
	@Valid
	@NotNull(message = "Tipo de pagamento não pode ser nulo")
	private PaymentMethodInput paymentMethod;
	
	@Valid
	@NotNull(message = "Edereço obrigatório")
	private AddressDTO address;
	
	@Valid
	@NotNull(message = "Restaurante não pode ser nulo")
	private RestaurantInput restaurant;
	
	@Size(min = 1)
	@NotNull(message = "Item do pedido não pode ser nulo")
	private List<OrderItemResume> items;
}
