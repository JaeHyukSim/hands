package com.bangkoklab.data.vo;

import java.sql.Timestamp;

public class AuthTimersVO {
	private String email;
	private Timestamp startTimer;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getStartTimer() {
		return startTimer;
	}

	public void setStartTimer(Timestamp startTimer) {
		this.startTimer = startTimer;
	}

	public AuthTimersVO(String email, Timestamp startTimer) {
		super();
		this.email = email;
		this.startTimer = startTimer;
	}

	@Override
	public String toString() {
		return "AuthTimersVO [email=" + email + ", startTimer=" + startTimer + "]";
	}

	public AuthTimersVO() {
		super();
		// TODO Auto-generated constructor stub
	}

}
