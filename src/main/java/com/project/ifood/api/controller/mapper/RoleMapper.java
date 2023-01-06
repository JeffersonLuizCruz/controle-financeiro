package com.project.ifood.api.controller.mapper;

import org.mapstruct.Mapper;

import com.project.ifood.api.controller.mapper.dto.RoleDTO;
import com.project.ifood.domain.model.Role;

@Mapper(componentModel = "spring")
public interface RoleMapper {
	
	Role toModel(RoleDTO dto);
	RoleDTO toDTO(Role role);

}
