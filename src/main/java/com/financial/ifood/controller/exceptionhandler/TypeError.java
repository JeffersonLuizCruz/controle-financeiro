package com.financial.ifood.controller.exceptionhandler;

import lombok.Getter;

@Getter
public enum TypeError {
	
	ENTITY_NOT_FOUND("/entidade-nao-encontrada", "Entidade não encontrada"),
	BAD_REQUEST_BODY_MESSAGE("/corpo-da-requisicao-invalido", "Corpo da requisição inválido");

	private String uri;
	private String title;

	private TypeError(String path, String title) {
		this.uri = "http://localhost:8181" + path;
		this.title = title;
	}

}
