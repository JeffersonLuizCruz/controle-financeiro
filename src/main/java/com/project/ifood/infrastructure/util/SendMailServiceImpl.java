package com.project.ifood.infrastructure.util;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import com.project.ifood.domain.properties.EmailProperties;
import com.project.ifood.domain.service.exception.EmailException;
import com.project.ifood.infrastructure.service.SendMailService;

import freemarker.template.Configuration;
import freemarker.template.Template;



@Service
public class SendMailServiceImpl implements SendMailService{

	@Autowired private JavaMailSender mailSend;
	@Autowired private EmailProperties emailProperties;
	@Autowired private Configuration freemarkerTemplate;
	
	@Override
	public void send(Message message) {
		try {
			String body = processEnginerTemplate(message);
			
			MimeMessage mime = mailSend.createMimeMessage();
			MimeMessageHelper help = new MimeMessageHelper(mime, "UTF-8");
			
			help.setFrom(emailProperties.getSender());
			help.setSubject(message.getSubject());
			help.setTo(message.getRecipients().toArray(new String[0]));
			help.setText(body, true);
			
			mailSend.send(mime);
		} catch (MessagingException e) {
			throw new EmailException("Alerta: Email não enviado", e);
		}
	}
	
	private String processEnginerTemplate(Message message) {
		try {
			Template template = freemarkerTemplate.getTemplate(message.getBody());
			return FreeMarkerTemplateUtils.processTemplateIntoString(template, message.getParams());
		} catch (Exception e) {
			throw new EmailException("Alerta: Email não enviado", e);
		} 
	}

}
