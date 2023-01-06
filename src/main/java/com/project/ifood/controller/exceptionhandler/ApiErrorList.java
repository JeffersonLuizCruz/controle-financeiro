package com.project.ifood.controller.exceptionhandler;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor @Data
public class ApiErrorList implements Serializable {
	private static final long serialVersionUID = -8240589805179726435L;
	
	private String message;
    private String field;
    private Object parameter;
}
