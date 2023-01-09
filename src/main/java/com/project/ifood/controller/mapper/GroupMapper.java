package com.project.ifood.controller.mapper;

import org.mapstruct.Mapper;

import com.project.ifood.controller.dto.GroupDTO;
import com.project.ifood.controller.dto.GroupResponseDTO;
import com.project.ifood.domain.model.Group;

@Mapper(componentModel = "spring")
public interface GroupMapper {
	
	Group toModel(GroupDTO dto);
	GroupResponseDTO toDTO(Group group);
}
