package com.bangkoklab.service;

import com.bangkoklab.data.vo.AuthRequestMessage;
import com.bangkoklab.data.vo.AuthResponseMessage;

public interface AuthRequestProgressService {
	AuthResponseMessage getAuthProgress(AuthRequestMessage authRequestMessage);
	AuthResponseMessage sendPassword(AuthRequestMessage authRequestMessage);
}
