package com.bangkoklab.data.vo;

public class ReviewImgVO {
	private String fileUuid;
	private String reviewId;
	private String path;
	private String fname;
	private long fsize;
	private String ftype;

	public String getFileUuid() {
		return fileUuid;
	}

	public void setFileUuid(String fileUuid) {
		this.fileUuid = fileUuid;
	}

	public String getReviewId() {
		return reviewId;
	}

	public void setReviewId(String reviewId) {
		this.reviewId = reviewId;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public long getFsize() {
		return fsize;
	}

	public void setFsize(long fsize) {
		this.fsize = fsize;
	}

	public String getFtype() {
		return ftype;
	}

	public void setFtype(String ftype) {
		this.ftype = ftype;
	}

	public ReviewImgVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReviewImgVO(String fileUuid, String reviewId, String path, String fname, long fsize, String ftype) {
		super();
		this.fileUuid = fileUuid;
		this.reviewId = reviewId;
		this.path = path;
		this.fname = fname;
		this.fsize = fsize;
		this.ftype = ftype;
	}

	@Override
	public String toString() {
		return "ReviewImgVO [fileUuid=" + fileUuid + ", reviewId=" + reviewId + ", path=" + path + ", fname=" + fname
				+ ", fsize=" + fsize + ", ftype=" + ftype + "]";
	}

}
