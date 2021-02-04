package com.bangkoklab.data.vo;

public class ReviewImgVO {
	private String userUuid;
	private String jobId;
	private String path;
	private String fname;
	private String fsize;
	private String ftype;
	private String fileUuid;

	public String getUserUuid() {
		return userUuid;
	}

	public void setUserUuid(String userUuid) {
		this.userUuid = userUuid;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
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

	public String getFsize() {
		return fsize;
	}

	public void setFsize(String fsize) {
		this.fsize = fsize;
	}

	public String getFtype() {
		return ftype;
	}

	public void setFtype(String ftype) {
		this.ftype = ftype;
	}

	public String getFileUuid() {
		return fileUuid;
	}

	public void setFileUuid(String fileUuid) {
		this.fileUuid = fileUuid;
	}

	public ReviewImgVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReviewImgVO(String userUuid, String jobId, String path, String fname, String fsize, String ftype,
			String fileUuid) {
		super();
		this.userUuid = userUuid;
		this.jobId = jobId;
		this.path = path;
		this.fname = fname;
		this.fsize = fsize;
		this.ftype = ftype;
		this.fileUuid = fileUuid;
	}

	@Override
	public String toString() {
		return "ReviewImgVO [userUuid=" + userUuid + ", jobId=" + jobId + ", path=" + path + ", fname=" + fname
				+ ", fsize=" + fsize + ", ftype=" + ftype + ", fileUuid=" + fileUuid + "]";
	}

}
