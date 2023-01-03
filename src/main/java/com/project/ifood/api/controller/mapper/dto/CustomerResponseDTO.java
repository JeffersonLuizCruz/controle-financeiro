package com.project.ifood.api.controller.mapper.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
public class CustomerResponseDTO {

	private Long id;
	private String name;
	private String email;
}
