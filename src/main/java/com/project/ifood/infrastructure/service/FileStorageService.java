package com.project.ifood.infrastructure.service;

import com.project.ifood.controller.dto.request.ProductPhotoRequest;

public interface FileStorageService {

	void storeFile(ProductPhotoRequest productPhotoRequest);
	
}
