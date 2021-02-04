package com.bangkoklab.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.bangkoklab.data.vo.ReviewRequestMessage;
import com.bangkoklab.data.vo.ReviewResponseMessage;
import com.bangkoklab.data.vo.ReviewUrlVO;
import com.bangkoklab.data.vo.ReviewVO;


public interface ReviewService {
	List<ReviewResponseMessage> getReviewProgress(ReviewRequestMessage reviewRequestMessage);
	List<ReviewVO> selectReview(String userUuid);
	List<ReviewUrlVO> selectReviewUrl(String reviewId);
	void getReviewToConsole(ReviewRequestMessage reviewRequestMessage);
	int insertReview(ReviewRequestMessage reviewRequestMessage, String targetUuid) throws Exception;
	String getTargetUuid(String contractId);
}