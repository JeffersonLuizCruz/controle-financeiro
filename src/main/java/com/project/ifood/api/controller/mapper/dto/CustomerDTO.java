package com.project.ifood.api.controller.mapper.dto;

import javax.validation.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
public class CustomerDTO {
	private String name;
	
	@Email(message = "Formato de email inválido!")
	private String email;
}
