package com.project.ifood.domain.event;

import com.project.ifood.domain.model.Order;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class OrderConfirmedEvent {

	private Order order;
}
