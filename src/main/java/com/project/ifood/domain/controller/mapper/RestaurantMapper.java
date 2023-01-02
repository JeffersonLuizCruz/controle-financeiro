package com.project.ifood.domain.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.project.ifood.domain.controller.mapper.dto.RestaurantDTO;
import com.project.ifood.domain.model.Restaurant;

@Mapper(componentModel = "spring")
public interface RestaurantMapper {

	@Mapping(source = "dto.address.city.state",  target = "address.city.state.name")
	Restaurant toModel(RestaurantDTO dto);
	
	@Mapping(source = "restaurant.address.city.state.name",  target = "address.city.state")
	RestaurantDTO toDTO(Restaurant restaurant);
}
