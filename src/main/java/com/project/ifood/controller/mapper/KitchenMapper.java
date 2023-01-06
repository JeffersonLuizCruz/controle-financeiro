package com.project.ifood.controller.mapper;

import org.mapstruct.Mapper;

import com.project.ifood.controller.dto.KitchenDTO;
import com.project.ifood.domain.model.Kitchen;

@Mapper(componentModel = "spring")
public interface KitchenMapper {
	
	Kitchen toModel(KitchenDTO dto);
	KitchenDTO toDTO(Kitchen kitchen);

}
