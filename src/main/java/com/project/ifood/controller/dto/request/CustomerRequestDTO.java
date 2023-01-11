package com.project.ifood.controller.dto.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
public class CustomerRequestDTO {
	
	@NotBlank(message = "Nome do usuário obrigatório!")
	private String name;
	
	@Email(message = "Formato de email inválido!")
	private String email;
	
	@NotBlank(message = "Senha obrigatória!")
	private String password;

}
