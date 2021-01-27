package com.bangkoklab.util;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;import com.bangkoklab.data.config.HandsGmailData;

public class Gmail extends Authenticator{
	
	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		HandsGmailData handsGmailData = new HandsGmailData();
		return new PasswordAuthentication(handsGmailData.getEmail(), handsGmailData.getPassword());
	}
}
