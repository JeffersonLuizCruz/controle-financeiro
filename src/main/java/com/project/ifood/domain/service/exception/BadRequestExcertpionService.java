package com.project.ifood.domain.service.exception;

public class BadRequestExcertpionService extends RuntimeException{
	private static final long serialVersionUID = 2622003751171000234L;

	public BadRequestExcertpionService(String message) {
		super(message);
	}
}
