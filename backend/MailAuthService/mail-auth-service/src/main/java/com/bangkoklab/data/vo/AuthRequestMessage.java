package com.bangkoklab.data.vo;

public class AuthRequestMessage {
	private String email;
	private String encryptedEmail;
	private String password;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AuthRequestMessage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AuthRequestMessage(String email, String encryptedEmail, String password) {
		super();
		this.email = email;
		this.encryptedEmail = encryptedEmail;
		this.password = password;
	}

	@Override
	public String toString() {
		return "AuthRequestMessage [email=" + email + ", encryptedEmail=" + encryptedEmail + ", password=" + password
				+ "]";
	}

}
