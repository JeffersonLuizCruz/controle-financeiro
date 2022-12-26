package com.project.ifood.service.exception;

public class ConstraintViolationService extends RuntimeException{
	private static final long serialVersionUID = 2146096093132654831L;

	public ConstraintViolationService(String message){
        super(message);
    }
}
