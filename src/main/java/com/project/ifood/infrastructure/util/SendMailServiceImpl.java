package com.project.ifood.infrastructure.util;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.project.ifood.domain.properties.EmailProperties;
import com.project.ifood.domain.service.exception.EmailException;
import com.project.ifood.infrastructure.service.SendMailService;

@Service
public class SendMailServiceImpl implements SendMailService{

	@Autowired private JavaMailSender mailSend;
	@Autowired private EmailProperties emailProperties;
	
	@Override
	public void send(Message message) {
		try {
			MimeMessage mime = mailSend.createMimeMessage();
			MimeMessageHelper help = new MimeMessageHelper(mime);
			
			help.setFrom(emailProperties.getSender());
			help.setSubject(message.getSubject());
			help.setTo(message.getRecipients().toArray(new String[0]));
			help.setText(message.getBody());
			
			mailSend.send(mime);
		} catch (MessagingException e) {
			throw new EmailException("Alerta: Email não enviado", e);
		}
	}

}
