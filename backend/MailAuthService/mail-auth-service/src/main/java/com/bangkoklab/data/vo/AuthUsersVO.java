package com.bangkoklab.data.vo;

public class AuthUsersVO {
	private String encryptedEmail;
	private String isAuthenticated;

	public String getEncryptedEmail() {
		return encryptedEmail;
	}

	public void setEncryptedEmail(String encryptedEmail) {
		this.encryptedEmail = encryptedEmail;
	}

	public String getIsAuthenticated() {
		return isAuthenticated;
	}

	public void setIsAuthenticated(String isAuthenticated) {
		this.isAuthenticated = isAuthenticated;
	}

	public AuthUsersVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AuthUsersVO(String encryptedEmail, String isAuthenticated) {
		super();
		this.encryptedEmail = encryptedEmail;
		this.isAuthenticated = isAuthenticated;
	}

	@Override
	public String toString() {
		return "AuthenticatedUsersVO [encryptedEmail=" + encryptedEmail + ", isAuthenticated=" + isAuthenticated + "]";
	}

}
