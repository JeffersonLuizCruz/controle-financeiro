package com.project.ifood.infrastructure.util;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.project.ifood.controller.dto.request.ProductPhotoRequest;
import com.project.ifood.infrastructure.service.FileStorageService;

@Service
public class FileStorageServiceImpl implements FileStorageService{

	@Value("${file.storage.photo}")
	private Path path;
	
	@Override
	public void storeFile(ProductPhotoRequest ppr) {
		try {
			Path tempFilePath = Files.createTempFile("product-photo-", ".tmp");
			ppr.getFile().transferTo(tempFilePath.toFile());
			Path finalFilePath = path.resolve(UUID.randomUUID() + "_" + ppr.getFile().getOriginalFilename());
			Files.move(tempFilePath, finalFilePath, StandardCopyOption.REPLACE_EXISTING);
			
		} catch (IOException | UncheckedIOException e) {
			throw new RuntimeException("Alerta: arquivo removido");
		} catch (Exception e) {
			throw new RuntimeException("Erro ao mover o arquivo: " + e.getMessage());
		}
	}

}
