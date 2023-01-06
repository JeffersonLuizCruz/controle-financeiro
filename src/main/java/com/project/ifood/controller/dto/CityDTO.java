package com.project.ifood.controller.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
public class CityDTO{


	@NotBlank(message = "Campo nome obrigatório!")
    private String name;

    @Valid
    @NotNull(message = "A inserção do Estado(object='state') é obrigatório!")
    private InputStateId state;
}
