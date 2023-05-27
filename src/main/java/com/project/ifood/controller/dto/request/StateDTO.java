package com.project.ifood.controller.dto.request;

import javax.validation.constraints.NotBlank;

import org.springframework.hateoas.RepresentationModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class StateDTO extends RepresentationModel<StateDTO>{

	@NotBlank(message = "Campo nome obrigatório!")
    private String name;
}