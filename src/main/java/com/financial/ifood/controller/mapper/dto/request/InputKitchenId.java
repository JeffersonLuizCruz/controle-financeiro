package com.financial.ifood.controller.mapper.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.*;



@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class InputKitchenId {
	
    @NotNull(message = "Id da Cozinha é obrigatório!")
    private Long id;
}
