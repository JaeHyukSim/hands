package com.bangkoklab.data.repository.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bangkoklab.data.vo.ReviewVO;

@Mapper
public interface ReviewMapper {
	ArrayList<ReviewVO> getReviewByUserUuid(String userUuid);
	int insertReview(ReviewVO reviewVO);
	int isReviewDuplicated(ReviewVO reviewVO);
	List<ReviewVO> getAllReview();
	List<ReviewVO> getReviewByTargetUuid(String targetUuid);
	int deleteReviewByContractId(String contractId);
	int deleteReviewAll();
}
