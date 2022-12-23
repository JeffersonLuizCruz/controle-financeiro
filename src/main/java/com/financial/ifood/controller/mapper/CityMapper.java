package com.financial.ifood.controller.mapper;

import com.financial.ifood.controller.mapper.dto.request.CityRequestDTO;
import com.financial.ifood.domain.model.City;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CityMapper {

    City toModel(CityRequestDTO dto);
    CityRequestDTO toDTO(City city);
}
