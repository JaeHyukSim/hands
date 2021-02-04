package com.bangkoklab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bangkoklab.data.vo.ImgOfOutput;
import com.bangkoklab.data.vo.ReviewMass;
import com.bangkoklab.data.vo.ReviewRequestMessage;
import com.bangkoklab.data.vo.ReviewUrlVO;
import com.bangkoklab.data.vo.ReviewVO;
import com.bangkoklab.service.ImgService;
import com.bangkoklab.service.ReviewService;
import com.bangkoklab.service.UrlService;

@RestController
@RequestMapping("/test")
public class ReviewTestController {
	@Autowired
	ReviewService reviewService;
	@Autowired
	ImgService imgService;
	@Autowired
	UrlService urlService;

	@GetMapping("/get-review-list")
	public List<ReviewVO> getReviewList(ReviewRequestMessage reviewRequestMessage) {
		return reviewService.selectReview(reviewRequestMessage.getUserUuid());
	}
	@GetMapping("/get-review-list-by-target")
	public List<ReviewVO> getReviewListByTarget(String targetUuid) {
		return reviewService.getReviewByTargetUuid(targetUuid);
	}

	@GetMapping("/get-review-url-list")
	public List<ReviewUrlVO> getReviewUrlList(ReviewRequestMessage reviewRequestMessage) {
		return reviewService.selectReviewUrl(reviewRequestMessage.getEmail());
	}
	

	/**
	 * 모든 데이터를 string 형태로 콘솔에 출력합니다
	 */
	@PostMapping("/get-review-data")
	public void getReviewData(ReviewRequestMessage reviewRequestMessage) {
		reviewService.getReviewToConsole(reviewRequestMessage);
	}

	/**
	 * 이미지를 서버에 저장한다
	 */
	@PostMapping("/save-imgs")
	public void saveImgs(ReviewRequestMessage reviewRequestMessage, String reviewId) {
		imgService.saveToServer(reviewRequestMessage, reviewRequestMessage.getImgs(), reviewId);
	}

	/**
	 * target uuid를 잘 받아오는지 검사합니다
	 */
	@GetMapping("/get-target-uuid")
	public String getTargetUuid(String contractId) {
		return reviewService.getTargetUuid(contractId);
	}

	/**
	 * review table에 값들이 잘 저장되는지 검사합니다
	 */
	@PutMapping("/insert-review")
	public void insertReview(ReviewRequestMessage reviewRequestMessage, String targetUuid, String reviewId)
			throws Exception {
		reviewService.insertReview(reviewRequestMessage, targetUuid, reviewId);
	}

	/**
	 * review img가 잘 저장되는지 검사합니다
	 */
	@PutMapping("/insert-review-img")
	public void insertImgs(ReviewRequestMessage reviewRequestMessage, String fileUuid, String path, MultipartFile img,
			String reviewId) throws Exception {
		imgService.insertImgs(reviewRequestMessage, fileUuid, path, img, reviewId);
	}

	/**
	 * url이 잘 저장되는지 검사합니다
	 */
	@PutMapping("/insert-review-url")
	public void insertReviewUrl(String reviewId, String url) {
		urlService.insertUrl(reviewId, url);
	}

	/**
	 * 리뷰 중복이 잘 되는지 테스트합니다
	 */
	@GetMapping("/is-review-duplicated")
	public int isReviewDuplicated(ReviewRequestMessage reviewRequestMessage) {
		return reviewService.isReviewDuplicated(reviewRequestMessage);
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
