package com.project.ifood.infrastructure.util.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.project.ifood.domain.properties.EmailProperties;
import com.project.ifood.infrastructure.service.SendMailService;

@Configuration
public class ConfigurationMail {

	@Autowired private EmailProperties emailProperties;
	
	@Bean
	public SendMailService sendMailService() {
		switch(emailProperties.getImpl()) {
		case FAKE:
			return new MockSmtpSendMailServiceImpl();
		case SMTP:
			return new SmtpSendMailServiceImpl();
		default:
			return null;
		}
	}
}
