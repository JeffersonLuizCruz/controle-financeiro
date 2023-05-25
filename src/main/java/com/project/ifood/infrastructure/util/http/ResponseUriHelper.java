package com.project.ifood.infrastructure.util.http;

import static org.springframework.http.HttpHeaders.LOCATION;

import java.net.URI;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ResponseUriHelper {

	public static void addUriInResponseHader(Object resourceId) {
		URI uri = ServletUriComponentsBuilder
		.fromCurrentRequestUri()
		.path("/{id}")
		.buildAndExpand(resourceId).toUri();
		
		HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
		response.setHeader(LOCATION, uri.toString());
	}
	
}
