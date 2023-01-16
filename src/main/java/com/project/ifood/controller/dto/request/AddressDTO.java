package com.project.ifood.controller.dto.request;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.project.ifood.controller.dto.input.CityInputById;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
public class AddressDTO {
	
	@NotBlank(message = "Campo obrigatório!")
	private String cep;
	@NotBlank(message = "Campo obrigatório!")
	private String street;
	@NotBlank(message = "Campo obrigatório!")
	private String number;
	@NotBlank(message = "Campo obrigatório!")
	private String complement;
	@NotBlank(message = "Campo obrigatório!")
	private String district;
	
    @Valid
    @NotNull(message = "A inserção da Cidade(object='city') é obrigatório!")
	private CityInputById city;
}
