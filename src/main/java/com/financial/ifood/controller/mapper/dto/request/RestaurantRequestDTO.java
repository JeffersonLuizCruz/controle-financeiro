package com.financial.ifood.controller.mapper.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.math.BigDecimal;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

@NoArgsConstructor @AllArgsConstructor @Data
public class RestaurantRequestDTO {

    @NotBlank(message = "Nome é obrigatório!")
    private String name;
    @NotBlank(message = "Frete é obrigatório!")
    @PositiveOrZero
    private BigDecimal freightRate;
    @Valid
    @NotNull(message = "A inserção da Cozinha(object='kitchen') é obrigatório!")
    private InputKitchenId kitchen;
}
