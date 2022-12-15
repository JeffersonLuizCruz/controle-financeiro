package com.financial.ifood.service.exception;

public class ConstraintViolationService extends RuntimeException{

    public ConstraintViolationService(String message){
        super(message);
    }
}
