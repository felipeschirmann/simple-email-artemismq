package br.dev.felipeschirmann.serviceEmail.interfaces;

import br.dev.felipeschirmann.serviceEmail.dto.EmailDetailsDTO;

public interface IEmailService {

	void sendSimpleMail(EmailDetailsDTO details);

}
