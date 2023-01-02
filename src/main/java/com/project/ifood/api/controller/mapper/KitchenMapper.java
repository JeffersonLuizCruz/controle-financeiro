package com.project.ifood.api.controller.mapper;

import org.mapstruct.Mapper;

import com.project.ifood.api.controller.mapper.dto.KitchenDTO;
import com.project.ifood.domain.model.Kitchen;

@Mapper(componentModel = "spring")
public interface KitchenMapper {
	
	Kitchen toModel(KitchenDTO dto);
	KitchenDTO toDTO(Kitchen kitchen);

}
