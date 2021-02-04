package com.bangkoklab.data.repository.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.bangkoklab.data.vo.ReviewVO;

@Mapper
public interface ReviewMapper {
	public ArrayList<ReviewVO> getReviewByUserUuid(String userUuid);
}
