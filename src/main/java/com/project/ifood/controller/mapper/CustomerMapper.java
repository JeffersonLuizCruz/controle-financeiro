package com.project.ifood.controller.mapper;

import org.mapstruct.Mapper;

import com.project.ifood.controller.dto.CustomerDTO;
import com.project.ifood.controller.dto.CustomerResponseDTO;
import com.project.ifood.controller.dto.CustomerResume;
import com.project.ifood.domain.model.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

	Customer toModel(CustomerResponseDTO dto);
	CustomerResponseDTO toDTO(Customer customer);
	Customer toModel(CustomerResume resume);
	Customer toModel(CustomerDTO dto);
}
