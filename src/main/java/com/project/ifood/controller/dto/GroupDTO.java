package com.project.ifood.controller.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
public class GroupDTO {
	
	@NotBlank(message = "O nome do group é obrigatório!")
	private String name;
}
