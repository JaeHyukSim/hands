package com.bangkoklab.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bangkoklab.data.repository.mapper.ReviewUrlMapper;
import com.bangkoklab.data.vo.ReviewUrlVO;
import com.bangkoklab.service.UrlService;

@Service
public class UrlServiceImpl implements UrlService{

	@Autowired
	ReviewUrlMapper reviewUrlMapper;
	/**
	 * url을 저장합니다 
	 */
	public int insertUrl(String reviewId, String url) {
		
		ReviewUrlVO reviewUrlVO = new ReviewUrlVO();
		
		String urlId = UUID.randomUUID().toString();
		
		reviewUrlVO.setUrlId(urlId);
		reviewUrlVO.setReviewId(reviewId);
		reviewUrlVO.setUrl(url);
		
		return reviewUrlMapper.insertReviewUrl(reviewUrlVO);
	}
	
	/**
	 * review_id로 url을 가져옵니다
	 */
	public List<ReviewUrlVO> getUrlsByReviewId(String reviewId) {
		return reviewUrlMapper.getUrlsByReviewId(reviewId);
	}
}
