package com.project.ifood.controller.dto.resume;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
public class CustomerPasswordResume {

	@NotBlank(message = "Senha atual obrigatório!")
	private String currentPassword;
	@NotBlank(message = "Nova senha obrigatório!")
	private String newPassword;
}
