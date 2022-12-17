package com.financial.ifood.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;

import com.financial.ifood.core.validation.Groups;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor @Data
@Entity @Table(name = "`restaurant`")
public class Restaurant implements Serializable{
	private static final long serialVersionUID = 7205353866673534942L;

	@NotNull(groups = Groups.RestaurantId.class,message = "Campo não pode ser nullo ou vazio!")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private BigDecimal freightRate;
	private Boolean isActive = Boolean.TRUE;;
	private Boolean isOpen = Boolean.FALSE;
	
	@CreationTimestamp
	@Column(nullable = false, columnDefinition = "datetime")
	private LocalDateTime createAt;
	
	@JsonIgnore
	@UpdateTimestamp
	@Column(nullable = false, columnDefinition = "datetime")
	private LocalDateTime updateAt;
	
	@JsonIgnore
	@Embedded
	private Address address;

	@Valid
	@ConvertGroup(from = Default.class, to = Groups.KitchenId.class)
	@NotNull(message = "Entidade kitchen é obrigatório!")
	@ManyToOne
	@JoinColumn(name = "kitchen_id", nullable = false)
	private Kitchen kitchen;
	

	@ManyToMany
	@JoinTable(name = "restaurant_payment_methods",
			joinColumns = @JoinColumn(name = "restaurants_id"),
			inverseJoinColumns = @JoinColumn(name = "payment_methods_id"))
	private Set<PaymentMethod> paymentMethods =  new HashSet<>();
	
	@ManyToMany
	@JoinTable(name = "restaurant_user_owner",
			joinColumns = @JoinColumn(name = "restaurant_id"),
			inverseJoinColumns = @JoinColumn(name = "owner_id"))
	private Set<Customer> owner = new HashSet<>();
	
	@JsonManagedReference
	@OneToMany(mappedBy = "restaurant")
	private List<Product> products = new ArrayList<>();
}
