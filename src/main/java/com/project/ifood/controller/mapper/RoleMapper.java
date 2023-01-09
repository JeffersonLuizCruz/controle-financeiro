package com.project.ifood.controller.mapper;

import org.mapstruct.Mapper;

import com.project.ifood.controller.dto.request.RoleDTO;
import com.project.ifood.domain.model.Role;

@Mapper(componentModel = "spring")
public interface RoleMapper {
	
	Role toModel(RoleDTO dto);
	RoleDTO toDTO(Role role);

}
