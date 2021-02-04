package com.bangkoklab.data.repository.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bangkoklab.data.vo.ReviewUrlVO;

@Mapper
public interface ReviewUrlMapper {
	ArrayList<ReviewUrlVO> getReviewUrlByReviewid(String reviewId);
	int insertReviewUrl(ReviewUrlVO reviewUrlVO);
	List<ReviewUrlVO> getUrlsByReviewId(String reviewId);
}
