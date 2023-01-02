package com.project.ifood.api.controller.mapper;

import org.mapstruct.Mapper;

import com.project.ifood.api.controller.mapper.dto.GroupDTO;
import com.project.ifood.domain.model.Group;

@Mapper(componentModel = "spring")
public interface GroupMapper {
	
	Group toModel(GroupDTO dto);
	GroupDTO toDTO(Group group);
}
