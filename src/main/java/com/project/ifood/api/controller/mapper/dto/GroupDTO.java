package com.project.ifood.api.controller.mapper.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
public class GroupDTO {
	
	@NotBlank(message = "O nome do group é obrigatório!")
	private String name;

	// TODO
	/**
	 * implementar o atributo role ??
	 * */
}
