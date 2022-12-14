package com.financial.ifood.controller.exceptionhandler;

import java.util.stream.Collectors;

import com.financial.ifood.service.exception.StateNotFoundException;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.databind.exc.PropertyBindingException;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.financial.ifood.service.exception.CityNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(StateNotFoundException.class)
	public ResponseEntity<ApiError> handlerStateNotFoundException(StateNotFoundException ex) {

		ApiError apiError = ApiError.builder()
				.status(HttpStatus.NOT_FOUND.value())
				.type(TypeError.RESOURCE_NOT_FOUND.getUri())
				.title(TypeError.RESOURCE_NOT_FOUND.getTitle())
				.detail(ex.getMessage())
				.build();

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
	}
	@ExceptionHandler(CityNotFoundException.class)
	public ResponseEntity<ApiError> handlerCityNotFoundException(CityNotFoundException ex) {
		
		ApiError apiError = ApiError.builder()
		.status(HttpStatus.NOT_FOUND.value())
		.type(TypeError.RESOURCE_NOT_FOUND.getUri())
		.title(TypeError.RESOURCE_NOT_FOUND.getTitle())
		.detail(ex.getMessage())
		.build();
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
	}
	
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		Throwable rootCause = ExceptionUtils.getRootCause(ex);

		if (rootCause instanceof InvalidFormatException) {
			return handleInvalidFormat((InvalidFormatException) rootCause, headers, status, request);
		}
		
		if (rootCause instanceof PropertyBindingException) {
			return handleInvalidFormat((UnrecognizedPropertyException) rootCause, headers, status, request);
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

	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex,
														HttpHeaders headers, HttpStatus status, WebRequest request) {

		if(ex instanceof TypeMismatchException){
			return handleMethodArgumentTypeMismatch((MethodArgumentTypeMismatchException) ex, headers, status, request);
		}

		return super.handleTypeMismatch(ex, headers, status, request);
	}

	/**
	 * add in the ' aplication.properties:
	 * spring.mvc.throw-exception-if-no-handler-found=true
	 * spring.web.resources.add-mappings=false '
	 * */
	@Override
	protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

		String detail = String.format("O recurso '%s', que você tentou acessar, é inexistente.", ex.getRequestURL());
		ApiError apiError = ApiError.builder()
				.type(TypeError.RESOURCE_NOT_FOUND.getUri())
				.title(TypeError.RESOURCE_NOT_FOUND.getTitle())
				.detail(detail)
				.build();

		return ResponseEntity.status(status.value()).body(apiError);
	}

	private ResponseEntity<Object> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex,
																	HttpHeaders headers, HttpStatus status, WebRequest request) {


		String detail = String.format("O parâmetro de URL '%s' recebeu o valor '%s', que é de um tipo" +
				" inválido. Corrija e informe um valor compatível com  o tipo %s", ex.getName(), ex.getValue(), ex.getRequiredType().getSimpleName());

		ApiError apiError = ApiError.builder()
				.type(TypeError.BAD_REQUEST_INVALID_PARAMETER.getUri())
				.title(TypeError.BAD_REQUEST_INVALID_PARAMETER.getTitle())
				.status(status.value())
				.detail(detail)
				.build();


		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
	}
	private ResponseEntity<Object> handleInvalidFormat(InvalidFormatException ex,
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

	private ResponseEntity<Object> handleInvalidFormat(UnrecognizedPropertyException ex,
													   HttpHeaders headers, HttpStatus status, WebRequest request) {

		String path = ex.getPath().stream()
				.map(ref -> ref.getFieldName())
				.findFirst().get();

		String detail = String.format("A propriedade '%s' é de um tipo inválido ou não existe. "
				+ "Corrija e informe um valor compatível com o tipo certo.",path);

		ApiError apiError = ApiError.builder()
				.title(TypeError.BAD_REQUEST_BODY_MESSAGE.getTitle())
				.status(status.value())
				.detail(detail)
				.build();


		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
	}
}
