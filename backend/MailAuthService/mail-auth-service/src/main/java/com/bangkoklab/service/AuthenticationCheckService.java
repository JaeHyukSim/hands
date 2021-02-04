package com.bangkoklab.service;

public interface AuthenticationCheckService {
	String getEncryptedEmail(String email);
	int isAuthenticated(String email) throws Exception;
	int insertAuthenticatedUsersByEncryptedEmail(String encryptedEmail) throws Exception;
	int isAuthenticatedByEncryptedEmail(String email);
	int updateNotCheckedByEncryptedEmail(String email);
	int updateCheckedByEncryptedEmail(String email);
	int deleteByEncryptedEmail(String email);
	int deleteAll();
	int insertByEncryptedEmail(String email);
}