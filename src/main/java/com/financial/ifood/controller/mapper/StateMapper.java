package com.financial.ifood.controller.mapper;

import com.financial.ifood.controller.mapper.dto.request.StateDTO;
import com.financial.ifood.domain.model.State;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StateMapper {

    State toModel(StateDTO tdo);
    StateDTO toDTO(State state);
}
