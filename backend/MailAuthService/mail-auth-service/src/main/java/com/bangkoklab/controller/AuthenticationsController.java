package com.bangkoklab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bangkoklab.service.ConfirmationService;
import com.bangkoklab.service.VerifyService;

/**
 * @packageName com.bangkoklab.controller
 * @author shimjaehyuk
 * @description 메일 인증 컨트롤러
 */
@RestController
public class AuthenticationsController {

	@Autowired
	private ConfirmationService authRequestProgressService;
	@Autowired
	private VerifyService authResponseProgressService;

	/**
	 * 
	 * @param 필요한 email
	 * @return org.springFramework.http.ResponseEntity<?>
	 * @author shimjaehyuk
	 * @description 메일로 인증 요청
	 */
	@GetMapping("/confirmation")
	public ResponseEntity<?> getAuthRequestAPI(String email) {

		MultiValueMap<String, String> header = new LinkedMultiValueMap<>();
		header.add("Content-Type", "text/html; charset=utf-8");
		
		switch (authRequestProgressService.getAuthProgress(email)) {
		case 200:
			header.add("message", "auth confirmation successed");
			return new ResponseEntity<>(header, HttpStatus.OK);
		case 409:
			header.add("message", "auth is already existed");
			return new ResponseEntity<>(header, HttpStatus.CONFLICT);
		default:
			header.add("message", "auth confirmation failed");
			return new ResponseEntity<>(header, HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * @param 암호화된 이메일 encrypted email
	 * @return org.springFramework.http.ResponseEntity<?>
	 * @author shimjaehyuk
	 * @description 인증 요청 완료 후 유저 등록
	 */
	@GetMapping("/verify")
	public ResponseEntity<?> getAuthResponseAPI(String encryptedEmail) {

		MultiValueMap<String, String> header = new LinkedMultiValueMap<String, String>();
		header.add("Content-Type", "text/html; charset=utf-8");
		
		switch (authResponseProgressService.getAuthProgress(encryptedEmail)) {
		case 200:
			header.add("message", "verify OK");
			return new ResponseEntity<>(header, HttpStatus.OK);
		case 4002:
			header.add("message", "can not verify");
			return new ResponseEntity<>(header, HttpStatus.BAD_REQUEST);
		case 4001:
			header.add("message", "expired");
			return new ResponseEntity<>(header, HttpStatus.BAD_REQUEST);
		default:
			header.add("message", "verify failed");
			return new ResponseEntity<>(header, HttpStatus.BAD_REQUEST);
		}
	}

}
