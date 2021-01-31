package com.bangkoklab.service;

public interface AuthenticationEmailService {
	void sendEmail(String email, String encrypedEmail) throws Exception;
}
