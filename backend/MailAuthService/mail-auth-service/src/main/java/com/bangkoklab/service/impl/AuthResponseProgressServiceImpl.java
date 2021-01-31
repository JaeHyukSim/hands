package com.bangkoklab.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bangkoklab.data.config.Configuration;
import com.bangkoklab.data.vo.AuthRequestMessage;
import com.bangkoklab.data.vo.AuthResponseMessage;
import com.bangkoklab.service.AuthResponseProgressService;
import com.bangkoklab.service.AuthenticationCheckService;
import com.bangkoklab.service.AuthenticationTimerService;

@Service
public class AuthResponseProgressServiceImpl implements AuthResponseProgressService {
	/**
	 * 인증을 확인하기 위한 인터페이스입니다.
	 */
	@Autowired
	private AuthenticationCheckService authenticationCheckService;
	@Autowired
	private AuthenticationTimerService authenticationTimerService;
	
	public AuthResponseMessage getAuthProgress(AuthRequestMessage authRequestMessage) {

		AuthResponseMessage msg = new AuthResponseMessage();
		String encryptedEmail = authRequestMessage.getEncryptedEmail();
		System.out.println(encryptedEmail);
		try {
			/**
			 * 인증이 이미 되었는지 검사합니다 != 0 : 이미 인증이 되었으므로 false를 리턴합니다 1 : 인증이 되지 않은 상태이므로 계속
			 * 진행합니다.
			 */
			if (authenticationCheckService.isAuthenticated(encryptedEmail) != 0) {
				msg.setAnswer("already authenticated ....");
				return msg;
			}

			/**
			 * 타이머를 체크한다
			 */
			if(authenticationTimerService.isExistedTimerByEncryptedEmail(encryptedEmail) == 0) {
				msg.setAnswer("타이머가 없다... ? ");
				return msg;
			}
			int endTimer = authenticationTimerService.getDiffMinuteByEmail(encryptedEmail);
			if(Configuration.timerMinuteLimit <= endTimer) {
				msg.setAnswer("타이머 만료됨... : timer 시간 = " + endTimer);
				return msg;
			}
			/**
			 * db에 인증정보를 저장한다.
			 */
			authenticationCheckService.insertAuthenticatedUsersByEncryptedEmail(encryptedEmail);
			/**
			 * 메시지를 전송한다
			 */
			msg.setAnswer("Authentication successed successfuly");
			return msg;
		} catch (Exception e) {
			e.printStackTrace();
			msg.setAnswer("Fail to transfer message...");
			return msg;
		}
	}
}
