package com.financial.ifood.controller.mapper.dto.request;

import com.financial.ifood.core.validation.Groups;
import com.financial.ifood.domain.model.State;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;
import java.io.Serializable;

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
