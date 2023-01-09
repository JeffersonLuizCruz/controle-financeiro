package com.project.ifood.controller.dto.input;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
public class StateIdInput {

    @NotNull(message = "Id do Estado é obrigatório!")
    private Long id;
}
