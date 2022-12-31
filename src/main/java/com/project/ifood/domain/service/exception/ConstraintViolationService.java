package com.project.ifood.domain.service.exception;

public class ConstraintViolationService extends RuntimeException{
	private static final long serialVersionUID = -6109102746511369333L;

	public ConstraintViolationService(String message){
        super(message);
    }
}
