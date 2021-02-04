/**
 * title : 클라이언트에게 메일을 보내는 기능을 관장하는 클래스입니다.
 */

package com.bangkoklab.service.impl;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

import com.bangkoklab.data.config.HandsGmailData;
import com.bangkoklab.service.AuthenticationEmailService;

@Service
public class AuthenticationEmailServiceImpl implements AuthenticationEmailService {
	public void sendEmail(String email, String encryptedEmail, String content, String subject) throws Exception {

		Properties properties = new Properties();

		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");

		HandsGmailData handsGmailData = new HandsGmailData();
		String myAccountEmail = handsGmailData.getEmail();
		String password = handsGmailData.getPassword();

		Session session = Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(myAccountEmail, password);
			}
		});

		Message message = prepareMessage(email, session, myAccountEmail, encryptedEmail, content, subject);

		Transport.send(message);

	}

	private Message prepareMessage(String email, Session session, String myAccountEmail, String encryptedEmail, String inputContent, String inputSubject) {
		
		String content = inputContent;

		Message message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(myAccountEmail));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
			message.setSubject(inputSubject);
			message.setContent(content, "text/html;charset=UTF8");

			return message;
		} catch (Exception e) {
			Logger.getLogger(AuthenticationEmailServiceImpl.class.getName()).log(Level.SEVERE, null, e);
		}
		return null;
	}

}
