package com.financial.ifood.controller.mapper.dto.request;


import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class InputKitchenId {
	
    @NotNull(message = "Id da Cozinha é obrigatório!")
    private Long id;
}
