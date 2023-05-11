package com.project.ifood.infrastructure.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import com.project.ifood.infrastructure.service.FileStorageService;

@Service
public class FileStorageServiceImpl implements FileStorageService{

	@Value("${file.storage.photo}")
	private Path path;

	@Override
	public void storage(InputStream inputStream, String originalFilename) {
	    Path tempFilePath = null;
	    try {
	        tempFilePath = Files.createTempFile("product-photo-", ".tmp");
	        FileCopyUtils.copy(inputStream, Files.newOutputStream(tempFilePath));
	        Files.move(tempFilePath, this.path.resolve(originalFilename));
	    } catch (IOException | UncheckedIOException e) {
			throw new RuntimeException("Alerta: arquivo removido");
		} catch (Exception e) {
			throw new RuntimeException("Erro ao mover o arquivo: " + e.getMessage());
		}
	}


	@Override
	public void remover(String originalFilename) {
		try {
			Files.deleteIfExists(path.resolve(originalFilename));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
