package com.project.ifood.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.project.ifood.controller.dto.request.RoleDTO;
import com.project.ifood.domain.model.Role;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoleMapper {
	
	Role toModel(RoleDTO dto);
	RoleDTO toDTO(Role role);

}
