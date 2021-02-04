package com.bangkoklab.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.bangkoklab.data.vo.ReviewRequestMessage;

public interface ImgService {
	void saveToServer(List<MultipartFile> imgs);
	int insertImgs(ReviewRequestMessage reviewRequestMessage, String fileUuid, String path, MultipartFile img, String reviewId) throws Exception;
}
