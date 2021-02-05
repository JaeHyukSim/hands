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

import com.bangkoklab.data.vo.ImgOfOutput;
import com.bangkoklab.data.vo.ReviewMass;
import com.bangkoklab.data.vo.ReviewRequestMessage;
import com.bangkoklab.data.vo.ReviewResponseMessage;
import com.bangkoklab.data.vo.ReviewUrlVO;
import com.bangkoklab.data.vo.ReviewVO;
import com.bangkoklab.service.ImgService;
import com.bangkoklab.service.ReviewService;
import com.bangkoklab.service.UrlService;

@RestController
@RequestMapping("/review")
public class ReviewCRUDController {
	
	@Autowired
	ReviewService reviewService;
	@Autowired
	ImgService imgService;
	@Autowired
	UrlService urlService;
	
	@GetMapping("/get-reviews")
	public List<ReviewResponseMessage> getReviews(ReviewRequestMessage reviewRequestMessage) {
		return reviewService.getReviewProgress(reviewRequestMessage);
	}
	
	/**
	 * review를 insert하는 컨트롤러입니다
	 * ****************************
	 * review를 insert하는 것은 일단 swagger2에서는 안되고
	 * static에 있는 index.html을 이용합니다.
	 * ---------------------------------------------
	 * 다음에 swagger에서 파일 업로드 되도록 구현해보기
	 */
	@PostMapping("/insert-review")
	public void insertReview(ReviewRequestMessage reviewRequestMessage) {
		reviewService.insertReviewProcess(reviewRequestMessage);
	}
	/**
	 * 리뷰 리스트를 user_uuid로 가져옵니다
	 * @param reviewRequestMessage
	 * @return
	 */
	@GetMapping("/get-review-list")
	public List<ReviewVO> getReviewList(ReviewRequestMessage reviewRequestMessage) {
		return reviewService.selectReview(reviewRequestMessage.getUserUuid());
	}
	/**
	 * 리뷰 리스트를 target uuid로 가져옵니다
	 * @param targetUuid
	 * @return
	 */
	@GetMapping("/get-review-list-by-target")
	public List<ReviewVO> getReviewListByTarget(String targetUuid) {
		return reviewService.getReviewByTargetUuid(targetUuid);
	}
	/**
	 * 모든 리뷰를 가져옵니다
	 */
	@GetMapping("/get-all-review")
	public List<ReviewVO> getAllReview() {
		return reviewService.getAllReview();
	}

	/**
	 * 모든 이미지를 가져옵니다
	 */
	@PostMapping("/get-img-by-review-id")
	public List<ImgOfOutput> getImgByReviewId(String reviewId) {
		return imgService.getImgByReviewId(reviewId);
	}

	/**
	 * 모든 url을 가져옵니다
	 */
	@GetMapping("/get-url-by-review-id")
	public List<ReviewUrlVO> getUrlByReviewId(String reviewId) {
		return urlService.getUrlsByReviewId(reviewId);
	}

	/**
	 * review와 imgs, urls를 모두 가져옵니다
	 */
	@GetMapping("get-mass-review")
	public List<ReviewMass> getMassReview() {
		return reviewService.getAllReviewWithImgAndUrl();
	}
}
