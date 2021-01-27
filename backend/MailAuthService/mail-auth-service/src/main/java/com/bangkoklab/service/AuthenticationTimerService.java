package com.bangkoklab.service;

public interface AuthenticationTimerService {
	void getTimerProgress(String email) throws Exception;
	int getDiffMinuteByEmail(String email) throws Exception;
	int isExistedTimer(String email) throws Exception;
}
