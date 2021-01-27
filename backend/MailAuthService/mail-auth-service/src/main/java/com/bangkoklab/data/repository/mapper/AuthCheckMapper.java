package com.bangkoklab.data.repository.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuthCheckMapper {
	int isCheckedByEmail(String email) throws Exception;
}
