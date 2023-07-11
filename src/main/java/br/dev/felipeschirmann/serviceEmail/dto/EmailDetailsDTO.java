package br.dev.felipeschirmann.serviceEmail.dto;

import java.io.Serializable;
import java.util.Objects;

import br.dev.felipeschirmann.serviceEmail.entities.EmailDetails;

public class EmailDetailsDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String recipient;
	private String msgBody;
	private String subject;

	EmailDetailsDTO() {
	}

	public EmailDetailsDTO(String recipient, String msgBody, String subject) {
		this.recipient = recipient;
		this.msgBody = msgBody;
		this.subject = subject;
	}

	public EmailDetailsDTO(EmailDetails entity) {
		this.recipient = entity.getRecipient();
		this.msgBody = entity.getMsgBody();
		this.subject = entity.getSubject();
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getMsgBody() {
		return msgBody;
	}

	public void setMsgBody(String msgBody) {
		this.msgBody = msgBody;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public int hashCode() {
		return Objects.hash(subject);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmailDetailsDTO other = (EmailDetailsDTO) obj;
		return Objects.equals(subject, other.subject);
	}

}
