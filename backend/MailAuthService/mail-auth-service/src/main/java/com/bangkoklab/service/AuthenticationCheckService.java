package com.bangkoklab.service;

public interface AuthenticationCheckService {
	boolean isAuthenticated(String email) throws Exception;
}
