package com.project.ifood.controller.exceptionhandler;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.databind.exc.PropertyBindingException;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.project.ifood.domain.service.exception.BadRequestExcertpionService;
import com.project.ifood.domain.service.exception.ConstraintViolationService;
import com.project.ifood.domain.service.exception.NotFoundExceptionService;

@ControllerAdvice
public class ApiGlobalExceptionHandler extends ResponseEntityExceptionHandler {

	/**
	 * TODO Remover ex.printStackTrace(); na fase de produção ex.printStackTrace();
	 * 
	 * @ExceptionHandler(Exception.class) public ResponseEntity<ApiError>
	 *                                    handleUncaught(Exception ex) {
	 * 
	 *                                    String detail = "Ocorreu um erro interno
	 *                                    inesperado no sistema. " + "Tente
	 *                                    novamente e se o problema persistir, entre
	 *                                    em contato " + "com o administrador do
	 *                                    sistema.";
	 * 
	 *                                    ex.printStackTrace();
	 * 
	 *                                    ApiError apiError = builder()
	 *                                    .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
	 *                                    .type(TypeError.INTERNAL_SERVER_ERROR.getUri())
	 *                                    .title(TypeError.INTERNAL_SERVER_ERROR.getTitle())
	 *                                    .detail(ex.getMessage())
	 *                                    .timestamp(OffsetDateTime.now()) .build();
	 * 
	 *                                    return
	 *                                    ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiError);
	 *                                    }
	 */

	@ExceptionHandler(BadRequestExcertpionService.class)
	public ResponseEntity<ApiError> handlerConstraintViolation(BadRequestExcertpionService ex) {

		ApiError apiError = ApiError.builder().status(HttpStatus.BAD_REQUEST.value())
				.title(TypeError.BAD_REQUEST_BODY_MESSAGE.getTitle()).detail(ex.getMessage())
				.timestamp(OffsetDateTime.now()).build();

		return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(apiError);
	}

	@ExceptionHandler(ConstraintViolationService.class)
	public ResponseEntity<ApiError> handlerConstraintViolation(ConstraintViolationService ex) {

		ApiError apiError = ApiError.builder().status(HttpStatus.CONFLICT.value())
				.title(TypeError.CONSTRAINT_VIOLATION.getTitle()).detail(ex.getMessage())
				.timestamp(OffsetDateTime.now()).build();

		return ResponseEntity.status(HttpStatus.CONFLICT.value()).body(apiError);
	}

	@ExceptionHandler(NotFoundExceptionService.class)
	public ResponseEntity<ApiError> handlerNotFoundException(NotFoundExceptionService ex) {

		ApiError apiError = ApiError.builder().status(HttpStatus.NOT_FOUND.value())
				.type(TypeError.RESOURCE_NOT_FOUND.getUri()).title(TypeError.RESOURCE_NOT_FOUND.getTitle())
				.detail(ex.getMessage()).timestamp(OffsetDateTime.now()).build();

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
	}

	@Override
	protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status,
			WebRequest request) {

		return handlePropertyBinding(ex, headers, status, request);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		Throwable rootCause = ExceptionUtils.getRootCause(ex);

		if (rootCause instanceof InvalidFormatException) {
			return handleInvalidFormat((InvalidFormatException) rootCause, headers, status, request);
		}

		if (rootCause instanceof PropertyBindingException) {
			return handlePropertyBinding((UnrecognizedPropertyException) rootCause, headers, status, request);
		}

		ApiError apiError = ApiError.builder().status(status.value()).type(TypeError.BAD_REQUEST_BODY_MESSAGE.getUri())
				.title(TypeError.BAD_REQUEST_BODY_MESSAGE.getTitle())
				.detail("Corpo da requisição inválido. Verifique erro de sintaxe.").timestamp(OffsetDateTime.now())
				.build();

		return ResponseEntity.status(status).body(apiError);
	}

	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {

		if (body == null) {
			body = ApiError.builder().title(status.getReasonPhrase()).status(status.value())
					.timestamp(OffsetDateTime.now()).build();
		} else if (body instanceof String) {
			body = ApiError.builder().title((String) body).status(status.value()).timestamp(OffsetDateTime.now())
					.build();
		}
		return super.handleExceptionInternal(ex, body, headers, status, request);
	}

	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {

		if (ex instanceof TypeMismatchException) {
			return handleMethodArgumentTypeMismatch((MethodArgumentTypeMismatchException) ex, headers, status, request);
		}

		return super.handleTypeMismatch(ex, headers, status, request);
	}

	/**
	 * add in the ' aplication.properties:
	 * spring.mvc.throw-exception-if-no-handler-found=true
	 * spring.web.resources.add-mappings=false '
	 */
	@Override
	protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {

		String detail = String.format("O recurso '%s', que você tentou acessar, é inexistente.", ex.getRequestURL());
		ApiError apiError = ApiError.builder().type(TypeError.RESOURCE_NOT_FOUND.getUri())
				.title(TypeError.RESOURCE_NOT_FOUND.getTitle()).detail(detail).timestamp(OffsetDateTime.now()).build();

		return ResponseEntity.status(status.value()).body(apiError);
	}

	// ToDo
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<ApiErrorList> fieldErros = ex.getBindingResult().getFieldErrors().stream()
				.map(fieldErro -> ApiErrorList.builder().message(fieldErro.getDefaultMessage())
						.field(fieldErro.getField()).parameter(fieldErro.getRejectedValue()).build())
				.collect(Collectors.toList());

		ApiError apiErro = ApiError.builder().timestamp(OffsetDateTime.now()).status(status.value())
				.type(HttpStatus.valueOf(status.value()).getReasonPhrase())
				.title(TypeError.ARGUMENT_NOT_VALID_EXCEPTION.getTitle()).detail(ex.getBindingResult().getObjectName())
				.errors(fieldErros).build();

		return ResponseEntity.status(status.value()).body(apiErro);
	}

	private ResponseEntity<Object> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		String detail = String.format(
				"O parâmetro de URL '%s' recebeu o valor '%s', que é de um tipo"
						+ " inválido. Corrija e informe um valor compatível com  o tipo %s",
				ex.getName(), ex.getValue(), ex.getRequiredType().getSimpleName());

		ApiError apiError = ApiError.builder().type(TypeError.BAD_REQUEST_INVALID_PARAMETER.getUri())
				.title(TypeError.BAD_REQUEST_INVALID_PARAMETER.getTitle()).status(status.value()).detail(detail)
				.timestamp(OffsetDateTime.now()).build();

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
	}

	private ResponseEntity<Object> handleInvalidFormat(InvalidFormatException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {

		String path = ex.getPath().stream().map(ref -> ref.getFieldName()).collect(Collectors.joining("."));

		String detail = String.format(
				"A propriedade '%s' recebeu o valor '%s', "
						+ "que é de um tipo inválido. Corrija e informe um valor compatível com o tipo %s.",
				path, ex.getValue(), ex.getTargetType().getSimpleName());

		ApiError apiError = ApiError.builder().title(TypeError.BAD_REQUEST_BODY_MESSAGE.getTitle())
				.type(TypeError.BAD_REQUEST_BODY_MESSAGE.getUri()).status(status.value()).detail(detail)
				.timestamp(OffsetDateTime.now()).build();

		return handleExceptionInternal(ex, apiError, headers, status, request);
	}

	private ResponseEntity<Object> handlePropertyBinding(UnrecognizedPropertyException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {

		String path = ex.getPath().stream().map(ref -> ref.getFieldName()).collect(Collectors.joining("."));

		String detail = String.format("A propriedade '%s' é de um tipo inválido ou não existe. "
				+ "Corrija e informe um valor compatível com o tipo certo.", path);

		ApiError apiError = ApiError.builder().title(TypeError.BAD_REQUEST_BODY_MESSAGE.getTitle())
				.status(status.value()).detail(detail).timestamp(OffsetDateTime.now()).build();

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
	}

	private ResponseEntity<Object> handlePropertyBinding(BindException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		
		String detail = String.format("Campo inválido '%s'. O valor do campo '%s' é de um tipo inválido ou não existe. "
				+ "Corrija e informe um valor compatível com o tipo certo.",ex.getFieldError().getField(), ex.getFieldValue("dateBegin"));
		
		ApiError apiError = ApiError.builder().type(TypeError.BAD_REQUEST_BODY_MESSAGE.getUri())
				.title(TypeError.BAD_REQUEST_BODY_MESSAGE.getTitle()).status(status.value()).detail(detail)
				.timestamp(OffsetDateTime.now()).build();
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
	}
}