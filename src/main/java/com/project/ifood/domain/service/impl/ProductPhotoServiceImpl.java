package com.project.ifood.domain.service.impl;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ifood.domain.model.ProductPhoto;
import com.project.ifood.domain.repositoy.ProductPhotoRepository;
import com.project.ifood.domain.service.ProductPhotoService;
import com.project.ifood.infrastructure.service.FileStorageService;

@Service
public class ProductPhotoServiceImpl implements ProductPhotoService{

	@Autowired private ProductPhotoRepository productPhotoRepository;
	@Autowired private FileStorageService fileStorageService;
	
	@Override
	public ProductPhoto save(ProductPhoto productPhoto) {
		Long productId = productPhoto.getProduct().getId();
		Long restaurantId = productPhoto.getRestaurantId();
		String originalFilenameExist = null;

		Optional<ProductPhoto> productExist = productPhotoRepository.findByProductAndRestaurant(productId, restaurantId);

		if(productExist.isPresent()) {
			originalFilenameExist = productExist.get().getFileName();
			productPhotoRepository.delete(productExist.get());;
		}
		
		ProductPhoto save = productPhotoRepository.saveAndFlush(productPhoto);
		fileStorageService.remover(originalFilenameExist);
		return save;
	}

}
