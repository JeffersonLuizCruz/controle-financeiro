package com.project.ifood.domain.controller.mapper.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class StateDTO {

	@NotBlank(message = "Campo nome obrigatório!")
    private String name;
}