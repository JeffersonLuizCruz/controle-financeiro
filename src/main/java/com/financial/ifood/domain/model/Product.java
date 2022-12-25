package com.financial.ifood.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonBackReference;

import com.financial.ifood.core.validation.Groups;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.ConvertGroup;
import jakarta.validation.groups.Default;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor @Data
@Entity
public class Product implements Serializable{
	private static final long serialVersionUID = 1524345699491374384L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String description;
	@Column(nullable = false)
	private BigDecimal price;
	@Column(nullable = false)
	private Boolean isActive;
	@Valid
	@ConvertGroup(from = Default.class, to = Groups.RestaurantId.class)
	@NotNull(message = "Entidade restaurant é obrigatório!")
	@JsonBackReference // https://www.baeldung.com/jackson-bidirectional-relationships-and-infinite-recursion
	@ManyToOne
	@JoinColumn(nullable = false)
	private Restaurant restaurant;
}
