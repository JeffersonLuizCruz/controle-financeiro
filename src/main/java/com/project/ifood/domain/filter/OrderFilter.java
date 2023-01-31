package com.project.ifood.domain.filter;

import java.time.OffsetDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor @Data
public class OrderFilter {

	private Long id;
	
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private OffsetDateTime dateBegin;
	
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private OffsetDateTime dateEnd;
}
