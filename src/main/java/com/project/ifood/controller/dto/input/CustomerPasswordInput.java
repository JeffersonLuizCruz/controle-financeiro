package com.project.ifood.controller.dto.input;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
public class CustomerPasswordInput {

	@NotBlank(message = "Senha atual obrigatório!")
	private String currentPassword;
	@NotBlank(message = "Nova senha obrigatório!")
	private String newPassword;
}
