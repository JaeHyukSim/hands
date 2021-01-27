package com.bangkoklab.service;

import com.bangkoklab.data.vo.AuthRequestMessage;

public interface AuthRequestProgressService {
	AuthRequestMessage getAuthProgress(String email);
}
