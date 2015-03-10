package org.edu.uams.server.api;


public class EmailDTO {

	private String username;
	private String password;
	private String fromAddress;
	private String toAddress;
	private String subject;
	private String emailBody;


	public EmailDTO(
			String toAddress, String subject, String emailBody) {
		super();
		this.toAddress = toAddress;
		this.subject = subject;
		this.emailBody = emailBody;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFromAddress() {
		return fromAddress;
	}
	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}
	public String getToAddress() {
		return toAddress;
	}
	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getEmailBody() {
		return emailBody;
	}
	public void setEmailBody(String emailBody) {
		this.emailBody = emailBody;
	}




}
