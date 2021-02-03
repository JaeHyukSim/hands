package com.bangkoklab.data.vo;

public class ReviewImg {
	private String imgId;

	public String getImgId() {
		return imgId;
	}

	public void setImgId(String imgId) {
		this.imgId = imgId;
	}

	public ReviewImg() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReviewImg(String imgId) {
		super();
		this.imgId = imgId;
	}

	@Override
	public String toString() {
		return "ReviewImg [imgId=" + imgId + "]";
	}

}
