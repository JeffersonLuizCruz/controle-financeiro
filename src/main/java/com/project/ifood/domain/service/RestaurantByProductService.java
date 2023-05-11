package com.project.ifood.domain.service;

import com.project.ifood.controller.dto.request.ProductDTO;
import com.project.ifood.domain.model.Product;
public interface RestaurantByProductService {

	Product saveRestaurantByProduct(Long restaurantId, ProductDTO dto);
	Product verifyIfExistRestaurantByProduct(Long restaurantId, Long productId);
}
