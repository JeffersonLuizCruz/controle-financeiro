package com.project.ifood.controller.mapper;

import org.mapstruct.Mapper;

import com.project.ifood.controller.dto.GroupDTO;
import com.project.ifood.domain.model.ProfileGroup;

@Mapper(componentModel = "spring")
public interface GroupMapper {
	
	ProfileGroup toModel(GroupDTO dto);
	GroupDTO toDTO(ProfileGroup group);
}
