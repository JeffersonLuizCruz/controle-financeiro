package com.project.ifood.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.project.ifood.controller.dto.request.KitchenDTO;
import com.project.ifood.controller.dto.response.KitchenResponseDTO;
import com.project.ifood.domain.model.Kitchen;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface KitchenMapper {
	
	Kitchen toModel(KitchenDTO dto);
	KitchenResponseDTO toDTO(Kitchen kitchen);

}
