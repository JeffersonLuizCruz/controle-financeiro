package com.project.ifood.controller.mapper;

import org.mapstruct.Mapper;

import com.project.ifood.controller.dto.ProductDTO;
import com.project.ifood.controller.dto.ProductResponseDTO;
import com.project.ifood.controller.dto.ProductResume;
import com.project.ifood.domain.model.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {

	Product toModel(ProductResume productResume);
	ProductResume toDTO(ProductDTO dto);
	ProductResponseDTO toDTO(Product product);
}
