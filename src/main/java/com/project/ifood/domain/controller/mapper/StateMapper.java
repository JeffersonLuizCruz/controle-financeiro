package com.project.ifood.domain.controller.mapper;

import org.mapstruct.Mapper;

import com.project.ifood.domain.controller.mapper.dto.request.StateRequestDTO;
import com.project.ifood.domain.model.State;

@Mapper(componentModel = "spring")
public interface StateMapper {

    State toModel(StateRequestDTO tdo);
    StateRequestDTO toDTO(State state);
}
