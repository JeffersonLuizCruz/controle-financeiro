package com.project.ifood.controller.mapper;

import org.mapstruct.Mapper;

import com.project.ifood.controller.dto.request.CustomerDTO;
import com.project.ifood.controller.dto.request.CustomerRequestDTO;
import com.project.ifood.controller.dto.response.CustomerResponseDTO;
import com.project.ifood.domain.model.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

	Customer toModel(CustomerResponseDTO dto);
	CustomerResponseDTO toDTO(Customer customer);
	Customer toModel(CustomerRequestDTO resume);
	Customer toModel(CustomerDTO dto);
}
