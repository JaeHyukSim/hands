package com.bangkoklab.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.bangkoklab.data.vo.ImgOfOutput;

/**
 * @packageName com.bangkoklab.service
 * @fileName ImgService
 * @author shimjaehyuk
 * @description 이미지 서비스
 **/
public interface ImgService {
	List<ImgOfOutput> getImgByReviewId(String reviewId);
	
	int insertImgs(String name, String path, MultipartFile img, String reviewId) throws Exception;
	
	int saveToServer(List<MultipartFile> imgs, String reviewId);
	
	int deleteImg(String reviewId) throws Exception;
}
