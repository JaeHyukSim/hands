package com.bangkoklab.service;

import java.util.List;

import com.bangkoklab.data.vo.ReviewUrlVO;

public interface UrlService {
	int insertUrl(String reviewId, String url);
	List<ReviewUrlVO> getUrlsByReviewId(String reviewId);
}
