package com.project.ifood.infrastructure.util.http;

import static org.springframework.http.HttpHeaders.LOCATION;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ResponseUriHelper {

	public static void addUriInResponseHader(Object resourceId) {
		UriComponents uri = ServletUriComponentsBuilder
		.fromCurrentRequestUri()
		.path("/{id}")
		.buildAndExpand(resourceId);
		
		HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
		response.setHeader(LOCATION, uri.toString());
	}
	
}
