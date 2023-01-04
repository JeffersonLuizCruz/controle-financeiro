package com.project.ifood.api.controller.mapper;

import org.mapstruct.Mapper;

import com.project.ifood.api.controller.mapper.dto.ProductDTO;
import com.project.ifood.api.controller.mapper.dto.ProductResponseDTO;
import com.project.ifood.api.controller.mapper.dto.ProductResume;
import com.project.ifood.domain.model.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {

	Product toModel(ProductResume productResume);
	ProductResume toDTO(ProductDTO dto);
	ProductResponseDTO toDTO(Product product);
}
