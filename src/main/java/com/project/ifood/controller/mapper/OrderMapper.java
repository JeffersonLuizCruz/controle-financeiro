package com.project.ifood.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.project.ifood.controller.dto.request.OrderDTO;
import com.project.ifood.controller.dto.response.OrderResponseDTO;
import com.project.ifood.domain.model.Order;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderMapper {

	Order toModel(OrderDTO dto);
	OrderResponseDTO toDTO(Order order);
}
