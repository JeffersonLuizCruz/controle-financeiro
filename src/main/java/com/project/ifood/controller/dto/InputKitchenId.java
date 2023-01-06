package com.project.ifood.controller.dto;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor @Data
public class InputKitchenId {
	
    @NotNull(message = "Id da Cozinha é obrigatório!")
    private Long id;
    
}
