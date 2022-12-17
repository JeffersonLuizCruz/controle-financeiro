package com.financial.ifood.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;

import com.financial.ifood.core.validation.Groups;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.pool.TypePool;

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
