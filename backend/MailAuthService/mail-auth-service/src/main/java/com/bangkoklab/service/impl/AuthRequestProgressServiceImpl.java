/**
 * title : authentication progress 모든 과정을 총괄하는 클래스입니다.
 * 
 * content : 이 클래스 내부에서는 3가지 단계가 수행됩니다
 * 			 1. 클라이언트가 이미 인증이 되었는지 확인합니다(인증이 되었으면 -> 이미인증되었다는 의미로 false를 return)
 * 			 2. client email을 전송합니다. 
 * 			 3. timer를 db에 등록합니다(auth_timers) + 클라이언트에게 인증 진행과정이 성공적이라는 결과를 리턴합니다.
 * 
 */


package com.bangkoklab.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bangkoklab.data.vo.AuthRequestMessage;
import com.bangkoklab.data.vo.AuthResponseMessage;
import com.bangkoklab.service.AuthRequestProgressService;
import com.bangkoklab.service.AuthenticationCheckService;
import com.bangkoklab.service.AuthenticationEmailService;
import com.bangkoklab.service.AuthenticationTimerService;
import com.bangkoklab.util.Key;
import com.bangkoklab.util.SHA256;

@Service
public class AuthRequestProgressServiceImpl implements AuthRequestProgressService {
	
	/**
	 * 인증을 확인하기 위한 인터페이스입니다.
	 */
	@Autowired
	private AuthenticationCheckService authenticationCheckService;
	@Autowired
	private AuthenticationTimerService authenticationTimerService;
	@Autowired
	private AuthenticationEmailService authenticationEmailService;
	
	public AuthResponseMessage getAuthProgress(AuthRequestMessage authRequestMessage) {
		
		AuthResponseMessage msg = new AuthResponseMessage();
		String email = authRequestMessage.getEmail();
		try {
			/**
			 * 받은 email을 암호화합니다.
			 */
			
			String encryptedEmail = SHA256.getSHA256(email, Key.key);
			
			/**
			 * 인증이 이미 되었는지 검사합니다
			 * 	!= 0 : 이미 인증이 되었으므로 false를 리턴합니다
			 *    1  : 인증이 되지 않은 상태이므로 계속 진행합니다.
			 */
			if(authenticationCheckService.isAuthenticated(encryptedEmail) != 0) {
				msg.setAnswer("already authenticated ....");
				return msg;
			}
			
			/**
			 * 클라이언트에게 인증메일을 전송합니다.
			 */
			authenticationEmailService.sendEmail(email, encryptedEmail);
			
			/**
			 * 타이머를 작동시킵니다.
			 */
			authenticationTimerService.getTimerProgress(encryptedEmail);
			
			msg.setAnswer("Message sent successfuly");
			return msg;
		} catch (Exception e) {
			e.printStackTrace();
			msg.setAnswer("Fail to transfer message...");
			return msg;
		}
	}
}
