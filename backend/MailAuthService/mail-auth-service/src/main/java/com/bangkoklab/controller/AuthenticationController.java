/**
 * title : 인증에 대한 API를 받는 컨트롤러입니다.
 * 
 * content : email 인증 과정을 주관하여 API Gateway로부터 인증 요청 API를 받고
 *           클라이언트의 email server에게 인증을 요청합니다.
 *           클라이언트로부터 인증 이메일 답신이 오면
 *           최종적으로 클라이언트를 인증해주는 서버입니다.
 *           
 * swagger2 : swagger2를 활용하여 API문서를 제공합니다
 * 
 * field summary : business logic을 제공받는 service layer가 있습니다
 * 
 * method summary : 
 */


package com.bangkoklab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bangkoklab.data.vo.AuthRequestMessage;
import com.bangkoklab.data.vo.AuthResponseMessage;
import com.bangkoklab.service.AuthRequestProgressService;
import com.bangkoklab.service.AuthResponseProgressService;
import com.bangkoklab.service.AuthenticationCheckService;
import com.bangkoklab.service.AuthenticationEmailService;
import com.bangkoklab.service.AuthenticationTimerService;
import com.bangkoklab.util.Key;
import com.bangkoklab.util.SHA256;


@RestController
@RequestMapping("/mail-auth")
public class AuthenticationController {
	
	@Autowired
	private AuthRequestProgressService authRequestProgressService;
	@Autowired
	private AuthResponseProgressService authResponseProgressService;
	
	@GetMapping("/auth-start-progress")
	public AuthResponseMessage getAuthRequestAPI(AuthRequestMessage authRequestMessage) {
		return authRequestProgressService.getAuthProgress(authRequestMessage);
	}
	
	@GetMapping("/auth-end-progress")
	public AuthResponseMessage getAuthResponseAPI(AuthRequestMessage authRequestMessage) {
		return authResponseProgressService.getAuthProgress(authRequestMessage);
	}
	
	
	@Autowired
	private AuthenticationCheckService authenticationCheckService;
	
	@GetMapping("/test")
	public int getTest(String email) throws Exception {
		return authenticationCheckService.isAuthenticated(email);
	}
	
	@Autowired
	private AuthenticationTimerService authenticationTimerService;
	
	@GetMapping("/test-timer")
	public void getTimerTest(String email) throws Exception {
		authenticationTimerService.getTimerProgress(email);
	}
	
	@Autowired
	private AuthenticationEmailService authenticationEmailService;
	
	@GetMapping("/test-email")
	public void getEmailTest(String email) throws Exception {
		authenticationEmailService.sendEmail(email, SHA256.getSHA256(email, Key.key));
	}
}
