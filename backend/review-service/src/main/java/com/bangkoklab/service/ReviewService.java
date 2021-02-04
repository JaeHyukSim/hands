package com.bangkoklab.service;

import java.util.List;

import com.bangkoklab.data.vo.ReviewRequestMessage;
import com.bangkoklab.data.vo.ReviewResponseMessage;
import com.bangkoklab.data.vo.ReviewUrlVO;
import com.bangkoklab.data.vo.ReviewVO;


public interface ReviewService {
	List<ReviewResponseMessage> getReviewProgress(ReviewRequestMessage reviewRequestMessage);
	List<ReviewVO> selectReview(String userUuid);
	List<ReviewUrlVO> selectReviewUrl(String reviewId);
}