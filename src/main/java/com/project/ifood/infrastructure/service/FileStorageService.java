package com.project.ifood.infrastructure.service;

import java.io.InputStream;

import com.project.ifood.controller.dto.request.ProductPhotoRequest;

public interface FileStorageService {

	void storeFile(ProductPhotoRequest productPhotoRequest, String originalFilename);

	void storage(InputStream inputStream, String originalFilename);
	void remover(String originalFilename);
}
