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
import com.bangkoklab.service.AuthRequestProgressService;
import com.bangkoklab.service.AuthenticationCheckService;

@Service
public class AuthRequestProgressServiceImpl implements AuthRequestProgressService {
	
	/**
	 * 인증을 확인하기 위한 인터페이스입니다.
	 */
	@Autowired
	private AuthenticationCheckService authenticationCheckService;
	
	public AuthRequestMessage getAuthProgress(String email) {
		
		AuthRequestMessage msg = new AuthRequestMessage();
		
		try {
			if(!authenticationCheckService.isAuthenticated(email)) {
				
				msg.setAnswer("false");
				return msg;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}
}
