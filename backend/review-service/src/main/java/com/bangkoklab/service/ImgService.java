package com.bangkoklab.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.bangkoklab.data.vo.ImgOfOutput;
import com.bangkoklab.data.vo.ReviewRequestMessage;

public interface ImgService {
	int saveToServer(ReviewRequestMessage reviewRequestMessage, List<MultipartFile> imgs, String reviewId);
	int insertImgs(ReviewRequestMessage reviewRequestMessage, String fileUuid, String path, MultipartFile img, String reviewId) throws Exception;
	List<ImgOfOutput> getImgByReviewId(String reviewId);
}
