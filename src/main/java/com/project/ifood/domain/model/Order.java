package com.project.ifood.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.project.ifood.domain.enums.OrderStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
@Entity @Table(name = "tb_order")
public class Order implements Serializable{
	private static final long serialVersionUID = -4564893146129034049L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String code;
	
	private BigDecimal subtotal;
	private BigDecimal freightRate;
	private BigDecimal totalAmount;

	@Embedded
	private Address deliveryAddress;
	
	@Enumerated(EnumType.STRING)
	private OrderStatus status = OrderStatus.CREATED;
	
	@CreationTimestamp
	private OffsetDateTime createAt;
	private OffsetDateTime confirmationAt;
	private OffsetDateTime cancellationAt;
	private OffsetDateTime deliveryAt;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private PaymentMethod paymentMethod;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Restaurant restaurant;
	
	@ManyToOne
	@JoinColumn(name = "user_client_id", nullable = false)
	private Customer customer;
	
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private List<OrderItem> items = new ArrayList<>();
	
	public void calculateTotalPrice() {
		items.forEach(OrderItem::calculateTotalPrice);
		
		this.subtotal = items.stream()
				.map(item -> item.getPriceTotal())
				.reduce(BigDecimal.ZERO,BigDecimal::add);
		
		this.totalAmount = this.subtotal.add(freightRate);
	}
}
