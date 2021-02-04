package com.bangkoklab.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bangkoklab.data.repository.mapper.ContractMapper;
import com.bangkoklab.data.repository.mapper.ReviewMapper;
import com.bangkoklab.data.repository.mapper.ReviewUrlMapper;
import com.bangkoklab.data.vo.ReviewRequestMessage;
import com.bangkoklab.data.vo.ReviewResponseMessage;
import com.bangkoklab.data.vo.ReviewUrlVO;
import com.bangkoklab.data.vo.ReviewVO;
import com.bangkoklab.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {
	@Autowired
	private ReviewMapper reviewMapper;
	@Autowired
	private ReviewUrlMapper reviewUrlMapper;
	@Autowired
	private ContractMapper contractMapper;
	/**
	 * title : 리뷰 리스트를 출력하는 프로그래스 서비스
	 * @param reviewRequestMessage
	 * @return
	 */
	public List<ReviewResponseMessage> getReviewProgress(ReviewRequestMessage reviewRequestMessage) {
		List<ReviewResponseMessage> res = new ArrayList<ReviewResponseMessage>();
		//1. review들을 list로 얻는다.
		List<ReviewVO> list = selectReview(reviewRequestMessage.getUserUuid());
		//2. 얻은 review list에 해당하는 url들을 얻는다.
		
		for(int i = 0; i < list.size(); i++) {
			//3. url들과 하나의 review를 response객체에 넣는다
			ReviewResponseMessage reviewResponseMessage = new ReviewResponseMessage();
			reviewResponseMessage.setUserUuid(list.get(i).getUserUuid());
			reviewResponseMessage.setContractId(list.get(i).getContractId());
			reviewResponseMessage.setReviewContent(list.get(i).getReviewContent());
			reviewResponseMessage.setScore(list.get(i).getScore());
			reviewResponseMessage.setTargetUuid(list.get(i).getTargetUuid());
			List<ReviewUrlVO> urlList = reviewUrlMapper.getReviewUrlByReviewid(list.get(i).getReviewId());
			reviewResponseMessage.setListOfUrl(urlList);
			res.add(reviewResponseMessage);
		}
		//4. response객체들을 list로 리턴한다
		return res;
	}
	
	/**
	 * title : user의 uuid를 이용하여 리뷰들을 찾아내는 서비스
	 * @param userUuid
	 * @return
	 */
	public List<ReviewVO> selectReview(String userUuid) {
		return reviewMapper.getReviewByUserUuid(userUuid);
	}
	
	public List<ReviewUrlVO> selectReviewUrl(String reviewId) {
		return reviewUrlMapper.getReviewUrlByReviewid(reviewId);
	}
	
	/**
	 * 받아온 데이터들을 콘솔에 출력합니다
	 */
	public void getReviewToConsole(ReviewRequestMessage reviewRequestMessage) {
		System.out.println("uuid : " + reviewRequestMessage.getUserUuid());
		System.out.println("content : " + reviewRequestMessage.getReviewContent());
		System.out.println("score : " + reviewRequestMessage.getScore());
		System.out.println("contract id : " + reviewRequestMessage.getContractId());
		for(MultipartFile img : reviewRequestMessage.getImgs()) {
			String originName = img.getOriginalFilename();
			String type = img.getContentType();
			long size = img.getSize();
			System.out.println("origin name : " + originName);
			System.out.println("type : " + type);
			System.out.println("size : " + size);
		}
		int i = 1;
		for(String url : reviewRequestMessage.getUrls()) {
			System.out.println("url " + i++ + ": " + url);
		}
	}
	
	/**
	 * contract로부터 target uuid를 받아옵니다
	 */
	public String getTargetUuid(String contractId) {
		return contractMapper.getHandyByContractId(contractId);
	}
	
	/**
	 * review table에 값들을 저장한다
	 */
	public int insertReview(ReviewRequestMessage reviewRequestMessage, String targetUuid) throws Exception{
		ReviewVO review = new ReviewVO();
		review.setReviewId(UUID.randomUUID().toString());
		review.setUserUuid(reviewRequestMessage.getUserUuid());
		review.setContractId(reviewRequestMessage.getContractId());
		review.setTargetUuid(targetUuid);
		review.setReviewRegdate(new Timestamp(System.currentTimeMillis()));
		review.setReviewContent(reviewRequestMessage.getReviewContent());
		review.setScore(reviewRequestMessage.getScore());
		
		return reviewMapper.insertReview(review);
	}
}
