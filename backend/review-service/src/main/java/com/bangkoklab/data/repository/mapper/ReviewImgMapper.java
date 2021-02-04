package com.bangkoklab.data.repository.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bangkoklab.data.vo.ReviewImgVO;

@Mapper
public interface ReviewImgMapper {
	int insertReviewImg(ReviewImgVO reviewImgVO);
	List<ReviewImgVO> getImgByReviewId(String reviewId);
}
