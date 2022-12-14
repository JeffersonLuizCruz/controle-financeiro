package com.financial.ifood.controller.exceptionhandler;

import lombok.Getter;

@Getter
public enum TypeError {
	
	RESOURCE_NOT_FOUND("/recurso-nao-encontrada", "Recurso não encontrada"),
	BAD_REQUEST_BODY_MESSAGE("/corpo-da-requisicao-invalido", "Corpo da requisição inválido"),
	BAD_REQUEST_INVALID_PARAMETER("/parametro-invalido", "Parâmetro de requisição inválido");

	private String uri;
	private String title;

	private TypeError(String path, String title) {
		this.uri = "http://localhost:8181" + path;
		this.title = title;
	}

}
