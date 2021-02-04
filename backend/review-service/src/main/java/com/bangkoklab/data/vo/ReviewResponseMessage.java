package com.bangkoklab.data.vo;

import java.sql.Timestamp;
import java.util.List;

public class ReviewResponseMessage {
	private String userUuid;
	private String email;
	private String encryptedEmail;
	private String targetUuid;
	private String targetEmail;
	private Timestamp reviewRegdate;
	private String contractId;
	private String reviewContent;
	private int score;
	private List<ReviewImg> listOfImg;
	private List<ReviewUrlVO> listOfUrl;

	public String getUserUuid() {
		return userUuid;
	}

	public void setUserUuid(String userUuid) {
		this.userUuid = userUuid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEncryptedEmail() {
		return encryptedEmail;
	}

	public void setEncryptedEmail(String encryptedEmail) {
		this.encryptedEmail = encryptedEmail;
	}

	public String getTargetUuid() {
		return targetUuid;
	}

	public void setTargetUuid(String targetUuid) {
		this.targetUuid = targetUuid;
	}

	public String getTargetEmail() {
		return targetEmail;
	}

	public void setTargetEmail(String targetEmail) {
		this.targetEmail = targetEmail;
	}

	public Timestamp getReviewRegdate() {
		return reviewRegdate;
	}

	public void setReviewRegdate(Timestamp reviewRegdate) {
		this.reviewRegdate = reviewRegdate;
	}

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public List<ReviewImg> getListOfImg() {
		return listOfImg;
	}

	public void setListOfImg(List<ReviewImg> listOfImg) {
		this.listOfImg = listOfImg;
	}

	public List<ReviewUrlVO> getListOfUrl() {
		return listOfUrl;
	}

	public void setListOfUrl(List<ReviewUrlVO> listOfUrl) {
		this.listOfUrl = listOfUrl;
	}

	public ReviewResponseMessage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReviewResponseMessage(String userUuid, String email, String encryptedEmail, String targetUuid,
			String targetEmail, Timestamp reviewRegdate, String contractId, String reviewContent, int score,
			List<ReviewImg> listOfImg, List<ReviewUrlVO> listOfUrl) {
		super();
		this.userUuid = userUuid;
		this.email = email;
		this.encryptedEmail = encryptedEmail;
		this.targetUuid = targetUuid;
		this.targetEmail = targetEmail;
		this.reviewRegdate = reviewRegdate;
		this.contractId = contractId;
		this.reviewContent = reviewContent;
		this.score = score;
		this.listOfImg = listOfImg;
		this.listOfUrl = listOfUrl;
	}

	@Override
	public String toString() {
		return "ReviewResponseMessage [userUuid=" + userUuid + ", email=" + email + ", encryptedEmail=" + encryptedEmail
				+ ", targetUuid=" + targetUuid + ", targetEmail=" + targetEmail + ", reviewRegdate=" + reviewRegdate
				+ ", contractId=" + contractId + ", reviewContent=" + reviewContent + ", score=" + score + "]";
	}

}
