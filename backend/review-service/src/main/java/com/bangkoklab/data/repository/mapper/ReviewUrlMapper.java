package com.bangkoklab.data.repository.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.bangkoklab.data.vo.ReviewUrlVO;

@Mapper
public interface ReviewUrlMapper {
	public ArrayList<ReviewUrlVO> getReviewUrlByReviewid(String reviewId);
}
