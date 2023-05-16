package com.project.ifood.domain.properties;

import javax.validation.constraints.NotBlank;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Validated
@Data
@Component
@ConfigurationProperties("ifood.email")
public class EmailProperties {

	@NotBlank
	private String sender;
	private Implementation impl = Implementation.FAKE;
	private SendBox sendbox = new SendBox();
	
	public enum Implementation {
		FAKE, SENDBOX, SMTP
	}
	
	@Data @NoArgsConstructor @AllArgsConstructor
	public class SendBox{
		private String description;
	}
}
