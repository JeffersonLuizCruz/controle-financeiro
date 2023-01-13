package com.project.ifood.domain.service;

import com.project.ifood.controller.dto.response.ProductResponseDTO;
import com.project.ifood.controller.dto.resume.ProductResume;
import com.project.ifood.domain.model.Product;
//TODO - Falta implementar os outros métodos
public interface RestaurantByProductService {

	Product saveRestaurantByProduct(Long restaurantId, ProductResume productResume);
	ProductResponseDTO verifyIfExistRestaurantByProduct(Long restaurantId, Long productId);
}
