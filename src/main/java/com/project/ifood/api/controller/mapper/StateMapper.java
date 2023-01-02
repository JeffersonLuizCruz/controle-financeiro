package com.project.ifood.api.controller.mapper;

import org.mapstruct.Mapper;

import com.project.ifood.api.controller.mapper.dto.StateDTO;
import com.project.ifood.domain.model.State;

@Mapper(componentModel = "spring")
public interface StateMapper {

    State toModel(StateDTO tdo);
    StateDTO toDTO(State state);
}
