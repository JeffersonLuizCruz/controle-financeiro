package com.project.ifood.controller.mapper;

import org.mapstruct.Mapper;

import com.project.ifood.controller.dto.request.ProductDTO;
import com.project.ifood.controller.dto.response.ProductResponseDTO;
import com.project.ifood.domain.model.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {

	Product toModel(ProductDTO dto);
	ProductResponseDTO toDTO(Product product);
}
