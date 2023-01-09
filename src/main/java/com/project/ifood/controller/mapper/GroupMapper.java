package com.project.ifood.controller.mapper;

import org.mapstruct.Mapper;

import com.project.ifood.controller.dto.request.GroupDTO;
import com.project.ifood.controller.dto.response.GroupResponseDTO;
import com.project.ifood.domain.model.Group;

@Mapper(componentModel = "spring")
public interface GroupMapper {
	
	Group toModel(GroupDTO dto);
	GroupResponseDTO toDTO(Group group);
}
