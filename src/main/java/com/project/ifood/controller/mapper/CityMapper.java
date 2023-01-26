package com.project.ifood.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.project.ifood.controller.dto.request.CityDTO;
import com.project.ifood.domain.model.City;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CityMapper {

    City toModel(CityDTO dto);
    CityDTO toDTO(City city);
}
