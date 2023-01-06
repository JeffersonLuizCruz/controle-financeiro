package com.project.ifood.controller.mapper;

import org.mapstruct.Mapper;

import com.project.ifood.controller.dto.CityDTO;
import com.project.ifood.domain.model.City;

@Mapper(componentModel = "spring")
public interface CityMapper {

    City toModel(CityDTO dto);
    CityDTO toDTO(City city);
}
