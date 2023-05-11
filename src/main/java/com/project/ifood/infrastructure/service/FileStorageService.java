package com.project.ifood.infrastructure.service;

import java.io.InputStream;

public interface FileStorageService {
	void storage(InputStream inputStream, String originalFilename);
	void remover(String originalFilename);
	InputStream getFile(String originalFilename);
}
