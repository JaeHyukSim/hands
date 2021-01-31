package com.bangkoklab.data.vo;

import java.sql.Timestamp;

public class AuthTimersVO {
	private String encryptedEmail;
	private String startTime;

	public String getEncryptedEmail() {
		return encryptedEmail;
	}

	public void setEncryptedEmail(String encryptedEmail) {
		this.encryptedEmail = encryptedEmail;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	@Override
	public String toString() {
		return "AuthTimersVO [encryptedEmail=" + encryptedEmail + ", startTime=" + startTime + "]";
	}

	public AuthTimersVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AuthTimersVO(String encryptedEmail, String startTime) {
		super();
		this.encryptedEmail = encryptedEmail;
		this.startTime = startTime;
	}

}
