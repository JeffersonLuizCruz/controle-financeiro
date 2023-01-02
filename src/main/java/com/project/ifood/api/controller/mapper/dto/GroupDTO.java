package com.project.ifood.api.controller.mapper.dto;

import javax.validation.constraints.NotBlank;

public class GroupDTO {
	
	@NotBlank(message = "O nome do group é obrigatório!")
	private String name;

}
