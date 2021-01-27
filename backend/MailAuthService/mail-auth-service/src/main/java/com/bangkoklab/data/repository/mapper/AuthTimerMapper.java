package com.bangkoklab.data.repository.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuthTimerMapper {
	int isExistedTimer(String email) throws Exception;
	int updateTimerByEmail(String email) throws Exception;
	int addTimerByEmail(String email) throws Exception;
}
