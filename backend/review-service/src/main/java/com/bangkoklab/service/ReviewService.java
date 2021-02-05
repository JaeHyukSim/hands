package com.bangkoklab.service;

import java.util.List;

import com.bangkoklab.data.vo.ReviewMass;
import com.bangkoklab.data.vo.ReviewRequestMessage;
import com.bangkoklab.data.vo.ReviewResponseMessage;
import com.bangkoklab.data.vo.ReviewUrlVO;
import com.bangkoklab.data.vo.ReviewVO;


public interface ReviewService {
	List<ReviewResponseMessage> getReviewProgress(ReviewRequestMessage reviewRequestMessage);
	List<ReviewVO> selectReview(String userUuid);
	List<ReviewVO> getReviewByTargetUuid(String targetUuid);
	List<ReviewUrlVO> selectReviewUrl(String reviewId);
	void getReviewToConsole(ReviewRequestMessage reviewRequestMessage);
	int insertReview(ReviewRequestMessage reviewRequestMessage, String targetUuid, String reviewId) throws Exception;
	String getTargetUuid(String contractId);
	int insertReviewProcess(ReviewRequestMessage reviewRequestMessage);
	int isReviewDuplicated(ReviewRequestMessage reviewRequestMessage);
	List<ReviewVO> getAllReview();
	List<ReviewMass> getAllReviewWithImgAndUrl();
	int deleteReviewByContractId(String contractId);
	int deleteReviewAll();
}