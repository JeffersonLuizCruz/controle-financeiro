package com.financial.ifood.controller.mapper;

import com.financial.ifood.controller.mapper.dto.request.StateRequestDTO;
import com.financial.ifood.domain.model.State;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StateMapper {

    State toModel(StateRequestDTO tdo);
    StateRequestDTO toDTO(State state);
}
