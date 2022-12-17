package com.financial.ifood.domain.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.financial.ifood.core.validation.Groups;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor @AllArgsConstructor @Data
@Entity
public class Kitchen implements Serializable{
	private static final long serialVersionUID = 5889582554209142655L;
	@NotNull(groups = Groups.KitchenId.class, message = "Campo não pode ser nullo ou vazio!")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@JsonIgnore
	@OneToMany(mappedBy = "kitchen")
	private List<Restaurant> restaurants;
}
