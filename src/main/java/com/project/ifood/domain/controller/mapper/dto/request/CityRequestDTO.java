package com.project.ifood.domain.controller.mapper.dto.request;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
public class CityRequestDTO{

    /**
     * É permitido inserção de String vazia. Mas não valor nulo.
     * */
    @NotNull
    private String name;

    @Valid
    @NotNull(message = "A inserção do Estado(object='state') é obrigatório!")
    private InputStateId state;
}