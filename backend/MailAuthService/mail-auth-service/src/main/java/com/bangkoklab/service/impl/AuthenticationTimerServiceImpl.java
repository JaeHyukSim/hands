/**
 * title : timer를 관리하는 클래스입니다
 * 
 * content : 1. 타이머가 이미 db에 존재하는지 확인
 * 			 2. 존재하면 갱신
 * 			 3. 존재하지 않으면 추가
 */

package com.bangkoklab.service.impl;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bangkoklab.data.repository.mapper.AuthTimerMapper;
import com.bangkoklab.service.AuthenticationTimerService;

@Service
public class AuthenticationTimerServiceImpl implements AuthenticationTimerService {

	@Autowired
	AuthTimerMapper authTimerMapper;

	public void getTimerProgress(String email) {
		/**
		 * 존재하는 경우
		 */
		try {
			if (isExistedTimer(email) == 1) {
				/**
				 * 갱신
				 */
				authTimerMapper.updateTimerByEmail(email);
				
			} else {
				/**
				 * 추가
				 */
				authTimerMapper.addTimerByEmail(email);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int getDiffMinuteByEmail(String email) throws Exception {
		
		return authTimerMapper.getDiffTime(email);
		
	}
	
	public int isExistedTimer(String email) throws Exception {
		return authTimerMapper.isExistedTimer(email);
	}
}
