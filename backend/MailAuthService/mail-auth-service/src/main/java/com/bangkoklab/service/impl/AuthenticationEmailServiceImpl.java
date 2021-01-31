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
	public void sendEmail(String email, String encryptedEmail) throws Exception {
		
		
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
		
		
		Message message = prepareMessage(email, session, myAccountEmail, email, encryptedEmail);
		
		Transport.send(message);
		
		
	}
	private Message prepareMessage(String email, Session session, String myAccountEmail, String recepient, String encryptedEmail) {
		String host = "http://localhost:8000";
		String contextPath = "/mail-auth";
		String url = "/mail-auth/auth-end-progress";
		String param = "?encryptedEmail=" + encryptedEmail;
		System.out.println("encryptedEmail : " + encryptedEmail);
		
		String totalUrl = host + contextPath + url + param;
		
		String content = "안녕하세요 hands입니다. 인증을 진행하기 위해 <a href=" + totalUrl +">여기</a>를 클릭하세요";
		
		Message message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(myAccountEmail));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
			message.setSubject("hands 인증 메일입니다.");
			message.setContent(content,"text/html;charset=UTF8");
			
			return message;
		} catch (Exception e) {
			Logger.getLogger(AuthenticationEmailServiceImpl.class.getName()).log(Level.SEVERE,null,e);
		}
		return null;
	}
}
