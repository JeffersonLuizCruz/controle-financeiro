package com.project.ifood.domain.event;

import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

import com.project.ifood.infrastructure.service.SendMailService;
import com.project.ifood.infrastructure.service.SendMailService.Message;

import lombok.AllArgsConstructor;

@Component @AllArgsConstructor
public class OrderConfirmedListeningEvent {

	private final SendMailService sendMailService; // Injeção é um @Bean: package com.project.ifood.infrastructure.util.email
	
	//@EventListener
	@TransactionalEventListener // O envio de email só vai acontecer depois da transação do banco estiver commitada.
	public void sendEmailWhenConfirmingOrder(OrderConfirmedEvent orderConfirmedEvent) {
		Message message = Message.builder()
		.subject("Pedido " + orderConfirmedEvent.getOrder().getCode() + "confirmado com sucesso!")
		.recipient(orderConfirmedEvent.getOrder().getCustomer().getEmail())
		.body("pedido-confirmado.html")
		.param("order", orderConfirmedEvent.getOrder())
		.build();
		
		sendMailService.send(message);
	}
}
