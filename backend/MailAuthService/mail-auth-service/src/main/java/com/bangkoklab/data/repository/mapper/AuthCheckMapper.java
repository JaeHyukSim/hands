package com.bangkoklab.data.repository.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuthCheckMapper {
	String isCheckedByEncryptedEmail(String encryptedEmail) throws Exception;
	int insertAuthenticatedUsersByEncryptedEmail(String encryptedEmail) throws Exception;
	int updateNotCheckedByEncryptedEmail(String encryptedEmail) throws Exception;
	int updateCheckedByEncryptedEmail(String encryptedEmail) throws Exception;
	int deleteByEncryptedEmail(String encryptedEmail) throws Exception;
	int deleteAll() throws Exception;
}