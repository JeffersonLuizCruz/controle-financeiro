package com.project.ifood.infrastructure.util.email;

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
public class SmtpSendMailServiceImpl implements SendMailService{

	@Autowired private JavaMailSender mailSend;
	@Autowired private EmailProperties emailProperties;
	@Autowired private Configuration freemarkerTemplate;
	
	@Override
	public void send(Message message) {
		try {
			String body = processEnginerTemplate(message);
			
			MimeMessage mime = createMimeMessage(message, body);
			
			mailSend.send(mime);
		} catch (MessagingException e) {
			throw new EmailException("Alerta: Email não enviado", e);
		}
	}

	private MimeMessage createMimeMessage(Message message, String body) throws MessagingException {
		MimeMessage mime = mailSend.createMimeMessage();
		MimeMessageHelper help = new MimeMessageHelper(mime, "UTF-8");
		
		help.setFrom(emailProperties.getSender());
		help.setSubject(message.getSubject());
		help.setTo(message.getRecipients().toArray(new String[0]));
		help.setText(body, true);
		return mime;
	}
	
	protected String processEnginerTemplate(Message message) {
		try {
			Template template = freemarkerTemplate.getTemplate(message.getBody());
			return FreeMarkerTemplateUtils.processTemplateIntoString(template, message.getParams());
		} catch (Exception e) {
			throw new EmailException("Alerta: Email não enviado", e);
		} 
	}

}
