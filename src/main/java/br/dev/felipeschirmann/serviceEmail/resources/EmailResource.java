package br.dev.felipeschirmann.serviceEmail.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.dev.felipeschirmann.serviceEmail.dto.EmailDetailsDTO;
import br.dev.felipeschirmann.serviceEmail.jms.JMSProducer;

@RestController
@RequestMapping(value = "/sendSimpleEmail")
public class EmailResource {

	@Autowired
	JMSProducer jmsProducer;

	@PostMapping
	public ResponseEntity<EmailDetailsDTO> SendEmail(@RequestBody EmailDetailsDTO dto) {
		jmsProducer.sendToQueue(dto);
		return ResponseEntity.ok().body(dto);
	}
}
