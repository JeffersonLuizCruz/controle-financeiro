package com.project.ifood.domain.controller.mapper;

import org.mapstruct.Mapper;

import com.project.ifood.domain.controller.mapper.dto.request.CityRequestDTO;
import com.project.ifood.domain.model.City;

@Mapper(componentModel = "spring")
public interface CityMapper {

    City toModel(CityRequestDTO dto);
    CityRequestDTO toDTO(City city);
}
