package com.bangkoklab.data.repository.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.bangkoklab.data.vo.ReviewImgVO;

@Mapper
public interface ReviewImgMapper {
	int insertReviewImg(ReviewImgVO reviewImgVO);
}
