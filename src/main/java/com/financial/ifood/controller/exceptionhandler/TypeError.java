package com.financial.ifood.controller.exceptionhandler;

import lombok.Getter;

@Getter
public enum TypeError {
	
	ENTITY_NOT_FOUND("/entidade-nao-encontrada", "Entidade não encontrada");

	private String title;
	private String uri;
	
	private TypeError(String path, String title) {
		this.uri = path;
		this.title = title;
	}

}
