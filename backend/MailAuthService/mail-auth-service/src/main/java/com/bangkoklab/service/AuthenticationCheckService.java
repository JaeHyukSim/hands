package com.bangkoklab.service;

public interface AuthenticationCheckService {
	int isAuthenticated(String email) throws Exception;
	int insertAuthenticatedUsersByEmail(String email) throws Exception;
}
