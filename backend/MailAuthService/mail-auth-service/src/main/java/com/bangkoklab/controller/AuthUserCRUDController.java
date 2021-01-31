package com.bangkoklab.controller;
/**
 * title : auth-users db에 대한 crud를 제공하는 컨트롤러입니다.
 * 
 * content : 
 * 1. 조회 
	2. 현재의 encrypted-email이 인증이 되었나?
2. 변경
	2. 현재의 encrypted-email의 인증 취소
	4. 현재의 encrypted-email의 인증 완료
3. 제거 
	2. 현재의 encrypted-email row 제거
	3. 모든 row 제거
4. 추가
	2. 현재의 encrypted-email 인증하기
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bangkoklab.data.vo.AuthRequestMessage;
import com.bangkoklab.data.vo.AuthResponseMessage;
import com.bangkoklab.service.AuthenticationCheckService;

@RestController
@RequestMapping("/auth-user")
public class AuthUserCRUDController {
	
	@Autowired
	AuthenticationCheckService authenticationCheckService; 
	
	/**
	 * title : 인증이 되었나 확인합니다.
	 * @param authRequestMessage
	 * @return
	 */
	@GetMapping("/is-auth-by-email")
	public AuthResponseMessage isAuthByEmail(AuthRequestMessage authRequestMessage) {
		AuthResponseMessage authResponseMessage = new AuthResponseMessage();
		authResponseMessage.setAnswer(String.valueOf(authenticationCheckService.isAuthenticatedByEncryptedEmail(authRequestMessage.getEmail())));
		return authResponseMessage;
	}
	
	/**
	 * 특정 email의 인증을 취소합니다
	 */
	@PutMapping("/cancel-auth-by-email")
	public AuthResponseMessage cancelAuthByEmail(AuthRequestMessage authRequestMessage) {
		AuthResponseMessage authResponseMessage = new AuthResponseMessage();
		authResponseMessage.setAnswer(String.valueOf(authenticationCheckService.updateNotCheckedByEncryptedEmail(authRequestMessage.getEmail())));
		return authResponseMessage;
	}
	/**
	 * 특정 email의 인증을 완료합니다
	 */
	@PutMapping("/get-auth-by-email")
	public AuthResponseMessage getAuthByEmail(AuthRequestMessage authRequestMessage) {
		AuthResponseMessage authResponseMessage = new AuthResponseMessage();
		authResponseMessage.setAnswer(String.valueOf(authenticationCheckService.updateCheckedByEncryptedEmail(authRequestMessage.getEmail())));
		return authResponseMessage;
	}
	
	/**
	 * 특정 email의 인증을 삭제합니다
	 */
	@DeleteMapping("/delete-auth-by-email")
	public AuthResponseMessage deleteAuthByEmail(AuthRequestMessage authRequestMessage) {
		AuthResponseMessage authResponseMessage = new AuthResponseMessage();
		authResponseMessage.setAnswer(String.valueOf(authenticationCheckService.deleteByEncryptedEmail(authRequestMessage.getEmail())));
		return authResponseMessage;
	}
	/**
	 * 모든 인증을 삭제합니다
	 */
	@DeleteMapping("/delete-all")
	public AuthResponseMessage deleteAll() {
		AuthResponseMessage authResponseMessage = new AuthResponseMessage();
		authResponseMessage.setAnswer(String.valueOf(authenticationCheckService.deleteAll()));
		return authResponseMessage;
	}
	/**
	 * 특정 email의 인증을 추가합니다
	 */
	@PutMapping("/insert-auth-by-email")
	public AuthResponseMessage insertAuthByEmail(AuthRequestMessage authRequestMessage) {
		AuthResponseMessage authResponseMessage = new AuthResponseMessage();
		authResponseMessage.setAnswer(String.valueOf(authenticationCheckService.insertByEncryptedEmail(authRequestMessage.getEmail())));
		return authResponseMessage;
	}
}
