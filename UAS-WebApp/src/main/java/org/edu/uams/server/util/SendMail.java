package org.edu.uams.server.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.edu.uams.server.api.EmailDTO;

public class SendMail {
	
	public static void sendMail(EmailDTO emailDTO) {
		
		final String serverMail = "vledeejay@gmail.com";
		final String serverMailPassword="deepak714jay";
		
		emailDTO.setUsername(serverMail);
		emailDTO.setPassword(serverMailPassword);
		
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
 
		Session session = Session.getInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(serverMail,serverMailPassword);
				}
			});
 
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(serverMail));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(emailDTO.getToAddress()));
			message.setSubject(emailDTO.getSubject());
			message.setText(emailDTO.getEmailBody());
 
			Transport.send(message);
 
			System.out.println("Done");
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

}
