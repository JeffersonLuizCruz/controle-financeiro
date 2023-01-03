package com.project.ifood.api.controller.mapper;

import org.mapstruct.Mapper;

import com.project.ifood.api.controller.mapper.dto.ProductDTO;
import com.project.ifood.domain.model.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {

	Product toModel(ProductDTO dto);
	ProductDTO toDTO(Product product);
}
