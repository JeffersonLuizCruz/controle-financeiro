package com.financial.ifood.domain.model;

import java.io.Serializable;


import com.financial.ifood.core.validation.Groups;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor @Data
@Entity
public class State implements Serializable{
	private static final long serialVersionUID = -9004431796005647934L;

	@NotNull(groups = Groups.StateId.class, message = "Campo não pode ser nullo ou vazio!")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;
}
