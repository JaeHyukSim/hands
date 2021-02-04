package com.bangkoklab.data.vo;

import java.sql.Timestamp;

public class AuthTimersVO {
	private String encryptedEmail;
	private Timestamp startTime;

	public String getEncryptedEmail() {
		return encryptedEmail;
	}

	public void setEncryptedEmail(String encryptedEmail) {
		this.encryptedEmail = encryptedEmail;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public AuthTimersVO() {
		super();
	}

	public AuthTimersVO(String encryptedEmail, Timestamp startTime) {
		super();
		this.encryptedEmail = encryptedEmail;
		this.startTime = startTime;
	}

	@Override
	public String toString() {
		return "AuthTimersVO [encryptedEmail=" + encryptedEmail + ", startTime=" + startTime + "]";
	}

}
