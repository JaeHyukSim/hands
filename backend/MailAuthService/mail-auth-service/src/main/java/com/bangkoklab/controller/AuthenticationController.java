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

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bangkoklab.service.AuthRequestProgressService;
import com.bangkoklab.service.AuthenticationCheckService;
import com.bangkoklab.service.AuthenticationTimerService;


@RestController
@RequestMapping("/mail-auth")
public class AuthenticationController {
	
	@Autowired
	private AuthRequestProgressService authRequestProgressService;
	
//	public Map<String, Integer> getAuthRequestAPI(String email) {
//		return new HashMap<String, Integer>();
//	}
	
	@Autowired
	private AuthenticationCheckService authenticationCheckService;
	
	@GetMapping("/test")
	public boolean getTest(String email) throws Exception{
		return authenticationCheckService.isAuthenticated(email);
	}
	
	@Autowired
	private AuthenticationTimerService authenticationTimerService;
	
	@GetMapping("/test-timer")
	public void getTimerTest(String email) throws Exception{
		authenticationTimerService.getTimerProgress(email);
	}
}
