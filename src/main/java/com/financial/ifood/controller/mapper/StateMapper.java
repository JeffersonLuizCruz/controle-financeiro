package com.financial.ifood.controller.mapper;

import com.financial.ifood.controller.mapper.dto.request.StateRequestDTO;
import com.financial.ifood.domain.model.State;

public interface StateMapper {

    State toModel(StateRequestDTO tdo);
    StateRequestDTO toDTO(State state);
}
