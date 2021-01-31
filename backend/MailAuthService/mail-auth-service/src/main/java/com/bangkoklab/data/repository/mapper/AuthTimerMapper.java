package com.bangkoklab.data.repository.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuthTimerMapper {
	int isExistedTimer(String encrypted_email) throws Exception;
	int updateTimerByEmail(String encrypted_email) throws Exception;
	int addTimerByEmail(String encrypted_email) throws Exception;
	int getDiffTime(String encrypted_email) throws Exception;
}
