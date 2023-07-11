package br.dev.felipeschirmann.serviceEmail.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import br.dev.felipeschirmann.serviceEmail.dto.EmailDetailsDTO;
import br.dev.felipeschirmann.serviceEmail.interfaces.IEmailService;

@Service
public class EmailService implements IEmailService {
	Logger logger = LoggerFactory.getLogger(EmailService.class);
	
	@Autowired
	private JavaMailSender javaMailSender;

	@Value("${spring.mail.username}")
	private String sender;

	public void sendSimpleMail(EmailDetailsDTO details) {
		try {
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setFrom(sender);
			mailMessage.setTo(details.getRecipient());
			mailMessage.setText(details.getMsgBody());
			mailMessage.setSubject(details.getSubject());

			javaMailSender.send(mailMessage);
			
			logger.info("Mail Sent Successfully...");
			
		} catch (Exception e) {
			
			logger.error("Error while Sending Mail {}", e);
		}
	}
}
