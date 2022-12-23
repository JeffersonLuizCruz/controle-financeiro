package com.financial.ifood.controller.mapper.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@NoArgsConstructor @AllArgsConstructor @Data
public class InputStateId {

    @NotNull(message = "Id do Estado é obrigatório!")
    Long id;
}
