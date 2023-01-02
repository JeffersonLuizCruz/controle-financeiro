package com.project.ifood.api.controller.mapper;

import org.mapstruct.Mapper;

import com.project.ifood.api.controller.mapper.dto.GroupDTO;
import com.project.ifood.domain.model.ProfileGroup;

@Mapper(componentModel = "spring")
public interface GroupMapper {
	
	ProfileGroup toModel(GroupDTO dto);
	GroupDTO toDTO(ProfileGroup group);
}
