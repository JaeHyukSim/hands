package com.bangkoklab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bangkoklab.data.vo.ReviewRequestMessage;
import com.bangkoklab.data.vo.ReviewUrlVO;
import com.bangkoklab.data.vo.ReviewVO;
import com.bangkoklab.service.ReviewService;

@RestController
@RequestMapping("/test")
public class ReviewTestController {
	@Autowired ReviewService reviewService;
	
	@GetMapping("/get-review-list")
	public List<ReviewVO> getReviewList(ReviewRequestMessage reviewRequestMessage) {
		return reviewService.selectReview(reviewRequestMessage.getUserUuid());
	}
	
	@GetMapping("/get-review-url-list")
	public List<ReviewUrlVO> getReviewUrlList(ReviewRequestMessage reviewRequestMessage) {
		return reviewService.selectReviewUrl(reviewRequestMessage.getEmail());
	}
}
