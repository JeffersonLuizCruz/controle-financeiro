package com.project.ifood.domain.controller.mapper;

import org.mapstruct.Mapper;

import com.project.ifood.domain.controller.mapper.dto.CityDTO;
import com.project.ifood.domain.model.City;

@Mapper(componentModel = "spring")
public interface CityMapper {

    City toModel(CityDTO dto);
    CityDTO toDTO(City city);
}
