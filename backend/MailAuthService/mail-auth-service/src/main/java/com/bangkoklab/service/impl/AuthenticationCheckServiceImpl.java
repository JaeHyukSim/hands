package com.bangkoklab.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bangkoklab.data.repository.mapper.AuthCheckMapper;
import com.bangkoklab.service.AuthenticationCheckService;

@Service
public class AuthenticationCheckServiceImpl implements AuthenticationCheckService {

	@Autowired
	private AuthCheckMapper authCheckMapper;

	/**
	 * 인증이 이미 되었는지 확인한다.
	 * 
	 * @throws Exception
	 */
	public boolean isAuthenticated(String email) throws Exception {
		return (authCheckMapper.isCheckedByEmail(email) == 1);
	}
}
