package com.bangkoklab.service;

import com.bangkoklab.data.vo.AuthRequestMessage;

public interface AuthResponseProgressService {
	AuthRequestMessage getAuthProgress(String email);
}
