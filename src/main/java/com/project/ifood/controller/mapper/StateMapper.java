package com.project.ifood.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.project.ifood.controller.dto.request.StateDTO;
import com.project.ifood.domain.model.State;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StateMapper {

    State toModel(StateDTO tdo);
    StateDTO toDTO(State state);
}
