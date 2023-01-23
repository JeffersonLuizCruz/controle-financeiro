package com.project.ifood.domain.repositoy.filter;

import java.time.OffsetDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor @Data
public class FilterOrder {

	
	private Long id;
	
	@DateTimeFormat(iso = ISO.DATE)
	private OffsetDateTime dateBegin;
	
	@DateTimeFormat(iso = ISO.DATE)
	private OffsetDateTime dateEnd;
}
