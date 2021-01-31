package com.bangkoklab.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bangkoklab.data.repository.mapper.AuthCheckMapper;
import com.bangkoklab.service.AuthenticationCheckService;
import com.bangkoklab.util.Key;
import com.bangkoklab.util.SHA256;

@Service
public class AuthenticationCheckServiceImpl implements AuthenticationCheckService {

	@Autowired
	private AuthCheckMapper authCheckMapper;

	/**
	 * 암호화 과정을 거칩니다
	 */
	public String getEncryptedEmail(String email) {
		return SHA256.getSHA256(email, Key.key);
	}

	/**
	 * 인증이 이미 되었는지 확인합니다.
	 * 
	 * @throws Exception
	 */
	public int isAuthenticated(String encryptedEmail) throws Exception {
		String isAuthenticated = authCheckMapper.isCheckedByEncryptedEmail(encryptedEmail);
		if (isAuthenticated == null)
			return 0;
		else if (isAuthenticated == "false")
			return 0;
		return 1;
	}

	/**
	 * 인증되었다고 테이블에 저장합니다.
	 */
	public int insertAuthenticatedUsersByEncryptedEmail(String email) throws Exception {
		return authCheckMapper.insertAuthenticatedUsersByEncryptedEmail(email);
	}

	/**
	 * 인증이 되었는지 확인합니다. 단, 받은 email을 암호화하여 검사합니다.
	 */

	public int isAuthenticatedByEncryptedEmail(String email) {
		try {
			String encryptedEmail = getEncryptedEmail(email);

			String isAuthenticated = authCheckMapper.isCheckedByEncryptedEmail(encryptedEmail);
			if (isAuthenticated == null)
				return 0;
			else if ("false".equals(isAuthenticated))
				return 0;
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	/**
	 * 현재의 email의 인증을 취소한다
	 */
	public int updateNotCheckedByEncryptedEmail(String email) {
		try {
			String encryptedEmail = getEncryptedEmail(email);
			return authCheckMapper.updateNotCheckedByEncryptedEmail(encryptedEmail);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * 현재의 email의 인증을 해준다
	 */
	public int updateCheckedByEncryptedEmail(String email) {
		try {
			String encryptedEmail = getEncryptedEmail(email);
			return authCheckMapper.updateCheckedByEncryptedEmail(encryptedEmail);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * 현재의 email의 인증을 삭제한다
	 */
	public int deleteByEncryptedEmail(String email) {
		try {
			String encryptedEmail = getEncryptedEmail(email);
			return authCheckMapper.deleteByEncryptedEmail(encryptedEmail);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	/**
	 * 모든 인증을 삭제한다
	 */
	public int deleteAll() {
		try {
			return authCheckMapper.deleteAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	/**
	 * 현재의 email을 인증에 추가합니다
	 */
	public int insertByEncryptedEmail(String email) {
		try {
			String encryptedEmail = getEncryptedEmail(email);
			return authCheckMapper.insertAuthenticatedUsersByEncryptedEmail(encryptedEmail);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
}
