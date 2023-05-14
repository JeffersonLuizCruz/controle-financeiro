package com.project.ifood.domain.properties;

import javax.validation.constraints.NotBlank;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import lombok.Data;

@Validated
@Data
@Component
@ConfigurationProperties("ifood.email")
public class EmailProperties {

	@NotBlank
	private String sender;
}
