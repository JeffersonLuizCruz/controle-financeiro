package com.project.ifood.domain.controller.mapper.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
public class AddressRequestDTO {
	
	private String cep;
	private String street;
	private String number;
	private String complement;
	private String district;
	private CityResume city;
}
