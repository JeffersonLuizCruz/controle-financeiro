package com.project.ifood.controller.exceptionhandler;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor @NoArgsConstructor @Data
public class ApiErrorList{

	private String message;
    private String field;
    private Object parameter;
}
