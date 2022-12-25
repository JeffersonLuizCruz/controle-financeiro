package com.financial.ifood.domain.model;

import java.io.Serializable;



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
public class City implements Serializable{
	private static final long serialVersionUID = 5135442260636444682L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String name;

	@Valid
	@ConvertGroup(from = Default.class, to = Groups.StateId.class)
	@NotNull(message = "Entidade State é obrigatório!")
	@ManyToOne
	@JoinColumn(name = "state_id", nullable = false)
	private State state;
}
