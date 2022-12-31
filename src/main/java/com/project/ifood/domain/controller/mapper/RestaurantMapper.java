package com.project.ifood.domain.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.project.ifood.domain.controller.mapper.dto.request.RestaurantRequestDTO;
import com.project.ifood.domain.model.Restaurant;

@Mapper(componentModel = "spring")
public interface RestaurantMapper {

	@Mapping(source = "dto.address.city.state",  target = "address.city.state.name")
	Restaurant toModel(RestaurantRequestDTO dto);
	
	@Mapping(source = "restaurant.address.city.state.name",  target = "address.city.state")
	RestaurantRequestDTO toDTO(Restaurant restaurant);
}
