package com.financial.ifood.controller.exceptionhandler;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.financial.ifood.service.exception.CityNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(CityNotFoundException.class)
	public ResponseEntity<ApiError> handlerCityNotFoundException(CityNotFoundException ex) {
		
		ApiError apiError = ApiError.builder()
		.status(HttpStatus.NOT_FOUND.value())
		.type(TypeError.ENTITY_NOT_FOUND.getUri())
		.title(TypeError.ENTITY_NOT_FOUND.getTitle())
		.detail(ex.getMessage())
		.build();
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
	}
	
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		Throwable rootCause = ExceptionUtils.getRootCause(ex);
		
		if (rootCause instanceof InvalidFormatException) {
			return handleInvalidFormatException((InvalidFormatException) rootCause, headers, status, request);
		}
		
		ApiError apiError = ApiError.builder()
		.status(status.value())
		.type(TypeError.BAD_REQUEST_BODY_MESSAGE.getUri())
		.title(TypeError.BAD_REQUEST_BODY_MESSAGE.getTitle())
		.detail("Corpo da requisição inválido. Verifique erro de sintaxe.")
		.build();
		
		return ResponseEntity.status(status).body(apiError);
	}

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
	
	private ResponseEntity<Object> handleInvalidFormatException(InvalidFormatException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		String path = ex.getPath().stream()
				.map(ref -> ref.getFieldName())
				.collect(Collectors.joining("."));

		String detail = String.format("A propriedade '%s' recebeu o valor '%s', "
				+ "que é de um tipo inválido. Corrija e informe um valor compatível com o tipo %s.",
				path, ex.getValue(), ex.getTargetType().getSimpleName());
		
		ApiError apiError = ApiError.builder()
 		.title(TypeError.BAD_REQUEST_BODY_MESSAGE.getTitle())
 		.type(TypeError.BAD_REQUEST_BODY_MESSAGE.getUri())
 		.status(status.value())
 		.detail(detail)
 		.build();
		
		return handleExceptionInternal(ex, apiError, headers, status, request);
	}
}
