package com.financial.ifood.controller.exceptionhandler;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Builder;
import lombok.Getter;

@JsonInclude(Include.NON_NULL)
@Getter
@Builder
public class ApiError implements Serializable{
	private static final long serialVersionUID = 6965291767201826269L;
	
	private Integer status;
	private String type;
	private String title;
	private String detail;
	private LocalDateTime timestamp;

}
