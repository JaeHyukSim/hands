package com.bangkoklab.data.vo;

import java.util.List;

public class ReviewMass {
	private ReviewVO reviewVO;
	private List<ImgOfOutput> imgs;
	private List<ReviewUrlVO> urls;

	public ReviewVO getReviewVO() {
		return reviewVO;
	}

	public void setReviewVO(ReviewVO reviewVO) {
		this.reviewVO = reviewVO;
	}

	public List<ImgOfOutput> getImgs() {
		return imgs;
	}

	public void setImgs(List<ImgOfOutput> imgs) {
		this.imgs = imgs;
	}

	public List<ReviewUrlVO> getUrls() {
		return urls;
	}

	public void setUrls(List<ReviewUrlVO> urls) {
		this.urls = urls;
	}

	public ReviewMass() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReviewMass(ReviewVO reviewVO, List<ImgOfOutput> imgs, List<ReviewUrlVO> urls) {
		super();
		this.reviewVO = reviewVO;
		this.imgs = imgs;
		this.urls = urls;
	}

	@Override
	public String toString() {
		return "ReviewMass [reviewVO=" + reviewVO + ", imgs=" + imgs + ", urls=" + urls + "]";
	}

}
