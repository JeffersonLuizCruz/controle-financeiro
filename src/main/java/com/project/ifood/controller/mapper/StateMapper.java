package com.project.ifood.controller.mapper;

import com.project.ifood.controller.mapper.dto.request.StateRequestDTO;
import com.project.ifood.domain.model.State;

public interface StateMapper {

    State toModel(StateRequestDTO tdo);
    StateRequestDTO toDTO(State state);
}
