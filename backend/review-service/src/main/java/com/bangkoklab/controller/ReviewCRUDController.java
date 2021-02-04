package com.bangkoklab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
/**
 * title : Review 테이블을 CRUD하는 컨트롤러입니다
 */
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bangkoklab.data.vo.ReviewRequestMessage;
import com.bangkoklab.data.vo.ReviewResponseMessage;
import com.bangkoklab.service.ReviewService;

@RestController
@RequestMapping("/review")
public class ReviewCRUDController {
	
	@Autowired
	ReviewService reviewService;
	
	@GetMapping("/get-reviews")
	public List<ReviewResponseMessage> getReviews(ReviewRequestMessage reviewRequestMessage) {
		return reviewService.getReviewProgress(reviewRequestMessage);
	}
	
	/**
	 * review를 insert하는 컨트롤러입니다
	 */
	@PostMapping("/insert-review")
	public void insertReview(ReviewRequestMessage reviewRequestMessage) {
		reviewService.insertReviewProcess(reviewRequestMessage);
	}
}
