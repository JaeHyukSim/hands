package com.bangkoklab.data.vo;

public class ReviewRequestMessage {
	private String email;
	private String encryptedEmail;
	private String userUuid;

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

	public String getUserUuid() {
		return userUuid;
	}

	public void setUserUuid(String userUuid) {
		this.userUuid = userUuid;
	}

	public ReviewRequestMessage() {
		super();
	}

	public ReviewRequestMessage(String email, String encryptedEmail, String userUuid) {
		super();
		this.email = email;
		this.encryptedEmail = encryptedEmail;
		this.userUuid = userUuid;
	}

	@Override
	public String toString() {
		return "ReviewRequestMessage [email=" + email + ", encryptedEmail=" + encryptedEmail + ", userUuid=" + userUuid
				+ "]";
	}

}
