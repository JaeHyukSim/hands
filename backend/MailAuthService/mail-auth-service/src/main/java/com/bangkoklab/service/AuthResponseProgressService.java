package com.bangkoklab.service;

import com.bangkoklab.data.vo.AuthRequestMessage;
import com.bangkoklab.data.vo.AuthResponseMessage;

public interface AuthResponseProgressService {
	AuthResponseMessage getAuthProgress(AuthRequestMessage authRequestMessage);
}
