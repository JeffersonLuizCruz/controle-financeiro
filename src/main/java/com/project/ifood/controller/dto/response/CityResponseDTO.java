package com.project.ifood.controller.dto.response;

import org.springframework.hateoas.RepresentationModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter 
@NoArgsConstructor @AllArgsConstructor
public class CityResponseDTO extends RepresentationModel<CityResponseDTO>{

	private Long id;
    private String name;
    private StateResponseDTO state;
}
