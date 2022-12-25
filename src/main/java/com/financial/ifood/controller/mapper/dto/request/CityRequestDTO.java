package com.financial.ifood.controller.mapper.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
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
