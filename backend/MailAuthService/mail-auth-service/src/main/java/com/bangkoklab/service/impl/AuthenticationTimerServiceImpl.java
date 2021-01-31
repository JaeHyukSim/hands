/**
 * title : timer를 관리하는 클래스입니다
 * 
 * content : 1. 타이머가 이미 db에 존재하는지 확인
 * 			 2. 존재하면 갱신
 * 			 3. 존재하지 않으면 추가
 */

package com.bangkoklab.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bangkoklab.data.config.Configuration;
import com.bangkoklab.data.repository.mapper.AuthTimerMapper;
import com.bangkoklab.service.AuthenticationTimerService;
import com.bangkoklab.util.Key;
import com.bangkoklab.util.SHA256;

@Service
public class AuthenticationTimerServiceImpl implements AuthenticationTimerService {

	@Autowired
	AuthTimerMapper authTimerMapper;

	/**
	 * 타이머의 동작 프로세스 메서드입니다.
	 */
	public void getTimerProgress(String encryptedEmail) {
		/**
		 * 존재하는 경우
		 */
		try {
			if (isExistedTimerByEncryptedEmail(encryptedEmail) == 1) {
				/**
				 * 갱신
				 */
				authTimerMapper.updateTimerByEncryptedEmail(encryptedEmail);

			} else {
				/**
				 * 추가
				 */
				authTimerMapper.addTimerByEncryptedEmail(encryptedEmail);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 타이머가 몇분 동작했는지 알려줍니다
	 */
	public int getDiffMinuteByEmail(String email) throws Exception {

		return authTimerMapper.getDiffTimeByEncryptedEmail(email);

	}

	/**
	 * 해당 email의 타이머가 존재하는지 확인합니다.(by encryptedEmail)
	 */
	public int isExistedTimerByEncryptedEmail(String encryptedEmail) throws Exception {
		return authTimerMapper.isExistedTimerByEncryptedEmail(encryptedEmail);
	}
	/**
	 * 해당 email의 타이머가 존재하는지 확인합니다.(by email)
	 */
	public int isExistedTimerByEmail(String email) {
		try {
			String encryptedEmail = SHA256.getSHA256(email, Key.key);
			return authTimerMapper.isExistedTimerByEncryptedEmail(encryptedEmail);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * 현재 encrypted-email의 start_time이 언제인지 조회합니다
	 */
	public String getStartTimeByEncryptedEmail(String email) {
		try {
			String encryptedEmail = SHA256.getSHA256(email, Key.key);
			return authTimerMapper.getStartTimeByEncryptedEmail(encryptedEmail);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 현재 encrypted-email의 만료 여부를 조회합니다
	 */
	public int isExpiredByEncryptedEmail(String email) {
		try {
			if(isExistedTimerByEmail(email) == 0) return 1; 
			String encryptedEmail = SHA256.getSHA256(email, Key.key);
			int endTimer = getDiffMinuteByEmail(encryptedEmail);
			if(Configuration.timerMinuteLimit <= endTimer) {
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * 현재의 encrypted-email의 타이머를 초기화합니다
	 */
	public int updateTimerByEncryptedEmail(String email) {
		try {
			String encryptedEmail = SHA256.getSHA256(email, Key.key);
			return authTimerMapper.updateTimerByEncryptedEmail(encryptedEmail);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * 현재의 encrypted-email의 timer를 삭제합니다
	 */
	public int deleteTimerByEncryptedEmail(String email) {
		try {
			String encryptedEmail = SHA256.getSHA256(email, Key.key);
			return authTimerMapper.deleteTimerByEncryptedEmail(encryptedEmail);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	/**
	 * 만료된 encrypted-email의 timer를 삭제합니다
	 */
	public int deleteAllByExpiredEmail() {
		try {
			return authTimerMapper.deleteAllByExpiredEmail(Configuration.timerMinuteLimit);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	/**
	 * 모든 timer를 삭제합니다
	 */
	public int deleteAll() {
		try {
			return authTimerMapper.deleteAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	/**
	 * 해당 email의 타이머를 추가합니다
	 */
	public int addTimerByEncryptedEmail(String email) {
		try {
			String encryptedEmail = SHA256.getSHA256(email, Key.key);
			return authTimerMapper.addTimerByEncryptedEmail(encryptedEmail);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
