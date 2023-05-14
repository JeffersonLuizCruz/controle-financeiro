package com.project.ifood.infrastructure.service;

import java.util.Map;
import java.util.Set;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.Singular;

public interface SendMailService {

	void send(Message message);
	
	@Data @Builder
	public class Message{
		
		@NonNull
		private String subject;
		@NonNull @Singular
		private Set<String> recipients;
		@NonNull
		private String body;
		@Singular
		private Map<String, Object> params;
	}
}
