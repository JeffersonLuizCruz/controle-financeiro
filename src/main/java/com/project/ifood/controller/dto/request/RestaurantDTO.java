package com.project.ifood.controller.dto.request;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import com.project.ifood.controller.dto.input.KitchenIdInput;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
public class RestaurantDTO {

	private Long id;
    @NotBlank(message = "Nome é obrigatório!")
	@Size(message = "Máximo permitido 20 caractere - size", max = 20)
    private String name;
    
    @PositiveOrZero
    private BigDecimal freightRate;
    private Boolean isActive;
    private Boolean isOpen;
    
    @NotNull(message = "A inserção da Cozinha(object='kitchen') é obrigatório!")
    private KitchenIdInput kitchen;
    

    @NotNull(message = "A inserção de Endereco(object='address') é obrigatório!")
    private AddressDTO address;
}
