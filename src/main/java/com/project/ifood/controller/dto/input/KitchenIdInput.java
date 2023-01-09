package com.project.ifood.controller.dto.input;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor @Data
public class KitchenIdInput {
	
    @NotNull(message = "Id da Cozinha é obrigatório!")
    private Long id;
    
}
