package com.project.ifood.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.project.ifood.controller.dto.request.RestaurantDTO;
import com.project.ifood.domain.model.Restaurant;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RestaurantMapper {

	//@Mapping(source = "dto.address.city.state",  target = "address.city.state.name")
	Restaurant toModel(RestaurantDTO dto);
	
	//@Mapping(source = "restaurant.address.city.state.name",  target = "address.city.state")
	RestaurantDTO toDTO(Restaurant restaurant);
}
