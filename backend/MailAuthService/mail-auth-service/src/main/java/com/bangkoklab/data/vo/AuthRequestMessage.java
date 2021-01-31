package com.bangkoklab.data.vo;

public class AuthRequestMessage {
	private String email;
	private String encryptedEmail;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEncryptedEmail() {
		return encryptedEmail;
	}

	public void setEncryptedEmail(String encryptedEmail) {
		this.encryptedEmail = encryptedEmail;
	}

	public AuthRequestMessage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AuthRequestMessage(String email, String encryptedEmail) {
		super();
		this.email = email;
		this.encryptedEmail = encryptedEmail;
	}

	@Override
	public String toString() {
		return "AuthRequestMessage [email=" + email + ", encryptedEmail=" + encryptedEmail + "]";
	}

}
