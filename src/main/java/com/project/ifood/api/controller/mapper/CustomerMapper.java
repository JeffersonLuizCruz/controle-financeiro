package com.project.ifood.api.controller.mapper;

import org.mapstruct.Mapper;

import com.project.ifood.api.controller.mapper.dto.CustomerDTO;
import com.project.ifood.api.controller.mapper.dto.CustomerResponseDTO;
import com.project.ifood.api.controller.mapper.dto.CustomerResume;
import com.project.ifood.domain.model.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

	Customer toModel(CustomerResponseDTO dto);
	CustomerResponseDTO toDTO(Customer customer);
	Customer toModel(CustomerResume resume);
	Customer toModel(CustomerDTO dto);
}
