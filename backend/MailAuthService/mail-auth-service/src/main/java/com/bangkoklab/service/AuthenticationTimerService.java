package com.bangkoklab.service;


public interface AuthenticationTimerService {
	void getTimerProgress(String email) throws Exception;
	int getDiffMinuteByEmail(String email) throws Exception;
	int isExistedTimerByEncryptedEmail(String encryptedEmail) throws Exception;
	int isExistedTimerByEmail(String email);
	String getStartTimeByEncryptedEmail(String email);
	int isExpiredByEncryptedEmail(String email);
	int updateTimerByEncryptedEmail(String email);
	int deleteTimerByEncryptedEmail(String email);
	int deleteAllByExpiredEmail();
	int deleteAll();
	int addTimerByEncryptedEmail(String email);
}