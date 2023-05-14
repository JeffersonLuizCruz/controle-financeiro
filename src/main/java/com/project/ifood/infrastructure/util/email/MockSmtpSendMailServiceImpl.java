package com.project.ifood.infrastructure.util.email;

import lombok.extern.slf4j.Slf4j;



@Slf4j
public class MockSmtpSendMailServiceImpl extends SmtpSendMailServiceImpl{

	@Override
	public void send(Message message) {
		String body = processEnginerTemplate(message);
		
		log.info("[FAKE E-MAIL] Para: {}\n{}", message.getRecipients(), body);
	}
	
}
