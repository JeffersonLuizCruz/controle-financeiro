package com.financial.ifood.controller.exceptionhandler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	 @Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		 //TODO debugar pra saber o que é o Object body
		 
		 if(body == null) {
			 body = ApiError.builder()
					 		.title(status.getReasonPhrase())
					 		.status(status.value())
					 		.build();
		 }else if(body instanceof String) {
			 body = ApiError.builder()
				 		.title((String) body)
				 		.status(status.value())
				 		.build();	 
		 }
		return super.handleExceptionInternal(ex, body, headers, status, request);
	}

}
