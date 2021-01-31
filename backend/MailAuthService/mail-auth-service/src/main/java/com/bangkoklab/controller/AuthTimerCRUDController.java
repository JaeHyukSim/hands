package com.bangkoklab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bangkoklab.data.vo.AuthRequestMessage;
import com.bangkoklab.data.vo.AuthResponseMessage;
import com.bangkoklab.service.AuthenticationTimerService;

/**
 * title : auth-timers에 대한 crud를 제공하는 컨트롤러입니다
 * 
 * content : 
 * 1. 조회
	1. 현재의 email이 timer에 존재합니까?
	2. 현재의 email의 start_timer의 값은?
	3. 현재의 email이 만료되었나?
2. 변경
	1. 현재의 email timer를 초기화한다
3. 제거
	1. 현재의 email timer를 제거한다
	2. 만료된 email timer를 제거한다
	3. 모든 timer를 제거한다
4. 추가
	1. 현재의 email의 timer를 생성한다
 * @author multicampus
 *
 */

@RestController
@RequestMapping("auth-timer")
public class AuthTimerCRUDController {

	@Autowired
	AuthenticationTimerService authenticationTimerService;
	
	/**
	 * 현재의 email이 timer에 존재하는지 확인합니다.
	 * @param authRequestMessage
	 * @return
	 */
	@GetMapping("/is-timer-by-email")
	public AuthResponseMessage isAuthByEmail(AuthRequestMessage authRequestMessage) {
		AuthResponseMessage authResponseMessage = new AuthResponseMessage();
		authResponseMessage.setAnswer(String.valueOf(authenticationTimerService.isExistedTimerByEmail(authRequestMessage.getEmail())));
		return authResponseMessage;
	}
	/**
	 * 현재의 email의 start_timer의 값을 구합니다
	 */
	@GetMapping("/get-start-by-email")
	public AuthResponseMessage getStartByEmail(AuthRequestMessage authRequestMessage) {
		AuthResponseMessage authResponseMessage = new AuthResponseMessage();
		authResponseMessage.setAnswer(String.valueOf(authenticationTimerService.getStartTimeByEncryptedEmail(authRequestMessage.getEmail())));
		return authResponseMessage;
	}
	/**
	 * 현재 email의 타이머가 만료되었는지 확인합니다
	 */
	@GetMapping("/is-expired-by-email")
	public AuthResponseMessage isExpiredByEmail(AuthRequestMessage authRequestMessage) {
		AuthResponseMessage authResponseMessage = new AuthResponseMessage();
		authResponseMessage.setAnswer(String.valueOf(authenticationTimerService.isExpiredByEncryptedEmail(authRequestMessage.getEmail())));
		return authResponseMessage;
	}
}
