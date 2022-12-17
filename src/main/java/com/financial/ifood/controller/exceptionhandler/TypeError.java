package com.financial.ifood.controller.exceptionhandler;

import lombok.Getter;

@Getter
public enum TypeError {
	
	RESOURCE_NOT_FOUND("/recurso-nao-encontrada", "Recurso não encontrada"),
	BAD_REQUEST_BODY_MESSAGE("/corpo-da-requisicao-invalido", "Corpo da requisição inválido"),
	BAD_REQUEST_INVALID_PARAMETER("/parametro-invalido", "Parâmetro de requisição inválido"),
	INTERNAL_SERVER_ERROR("/server-error", "Erro interno do servidor"),
	CONSTRAINT_VIOLATION("/entidade-existente", "Entidade em uso"),
	ARGUMENT_NOT_VALID_EXCEPTION ("/atributo-invalido", "Campo inválido!");

	private String uri;
	private String title;

	private TypeError(String path, String title) {
		this.uri = "http://localhost:8181" + path;
		this.title = title;
	}

}
