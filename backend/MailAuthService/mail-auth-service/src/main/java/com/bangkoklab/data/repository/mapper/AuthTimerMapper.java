package com.bangkoklab.data.repository.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuthTimerMapper {
	int isExistedTimerByEncryptedEmail(String encryptedEmail) throws Exception;
	int updateTimerByEncryptedEmail(String encryptedEmail) throws Exception;
	int addTimerByEncryptedEmail(String encryptedEmail) throws Exception;
	int getDiffTimeByEncryptedEmail(String encryptedEmail) throws Exception;
	String getStartTimeByEncryptedEmail(String encryptedEmail) throws Exception;
	int deleteTimerByEncryptedEmail(String encryptedEmail) throws Exception;
	int deleteAllByExpiredEmail(int time) throws Exception;
	int deleteAll() throws Exception;
}