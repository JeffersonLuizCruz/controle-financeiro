package com.project.ifood.controller.dto.response;

import org.springframework.hateoas.RepresentationModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class StateResponseDTO extends RepresentationModel<StateResponseDTO>{

	private Long id;
	private String name;
}
