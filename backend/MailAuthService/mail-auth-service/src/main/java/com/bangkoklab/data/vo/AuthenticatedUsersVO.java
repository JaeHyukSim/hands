package com.bangkoklab.data.vo;

public class AuthenticatedUsersVO {
	private String mail;
	private String sAuthenticated;

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getsAuthenticated() {
		return sAuthenticated;
	}

	public void setsAuthenticated(String sAuthenticated) {
		this.sAuthenticated = sAuthenticated;
	}

	public AuthenticatedUsersVO(String mail, String sAuthenticated) {
		super();
		this.mail = mail;
		this.sAuthenticated = sAuthenticated;
	}

	public AuthenticatedUsersVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "AuthenticatedUsersVO [mail=" + mail + ", sAuthenticated=" + sAuthenticated + "]";
	}

}
