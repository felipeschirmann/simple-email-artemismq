package br.dev.felipeschirmann.serviceEmail.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.dev.felipeschirmann.serviceEmail.dto.EmailDetailsDTO;
import br.dev.felipeschirmann.serviceEmail.services.EmailService;

@Component
public class JMSConsumer {

	@Autowired
	EmailService service;

	Logger logger = LoggerFactory.getLogger(JMSConsumer.class);
	
	@JmsListener(destination = "${spring.artemis.queue}")
	public void consumer(String msg) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			EmailDetailsDTO dto = objectMapper.readValue(msg, EmailDetailsDTO.class);
			service.sendSimpleMail(dto);
			logger.info("Email send to {}", dto.getRecipient());
		} catch (Exception e) {
			logger.error("Email not send {}", e);
		}
	}
}
