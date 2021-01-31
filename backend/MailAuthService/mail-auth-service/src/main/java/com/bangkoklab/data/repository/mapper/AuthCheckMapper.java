package com.bangkoklab.data.repository.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuthCheckMapper {
	int isCheckedByEmail(String encrypted_email) throws Exception;
	int insertAuthenticatedUsersByEmail(String encrypted_email) throws Exception;
}
