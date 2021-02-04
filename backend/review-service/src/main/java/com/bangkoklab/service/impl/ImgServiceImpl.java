package com.bangkoklab.service.impl;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bangkoklab.data.repository.mapper.ReviewImgMapper;
import com.bangkoklab.data.vo.ReviewImgVO;
import com.bangkoklab.data.vo.ReviewRequestMessage;
import com.bangkoklab.service.ImgService;

import net.coobird.thumbnailator.Thumbnails;

@Service
public class ImgServiceImpl implements ImgService {

	@Autowired
	ReviewImgMapper reviewImgMapper;
	
	/**
	 * img들을 file에 저장합니다(원본과 썸네일)
	 */
	public void saveToServer(List<MultipartFile> imgs) {
		Date today = new Date();
		SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
		SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
		SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
		String year = yearFormat.format(today);
		String month = monthFormat.format(today);
		String day = dayFormat.format(today);

		for (MultipartFile img : imgs) {
			String uuid = UUID.randomUUID().toString();
			String orgName = img.getOriginalFilename();
			int index = orgName.lastIndexOf(".");
			String ext = "";
			if(index != -1) {
				ext = orgName.substring(index);
			}
			String path = "C:/hands/uploads/" + year + "/" + month + "/" + day;
			String name = uuid + ext;
			File file = new File(path, name);
			file.mkdirs();
			try {
				img.transferTo(file);
				if(img.getContentType().startsWith("image/")) {
					Thumbnails.of(file) // file 파일을 기반으로 해서 만든다.
							  .size(400,200)
							  .toFile(new File(file.getParent(),"thumb_" + name));
				}
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	/**
	 * db에 img를 저장합니다
	 */
	public int insertImgs(ReviewRequestMessage reviewRequestMessage, String name, String path, MultipartFile img, String reviewId) throws Exception{
		ReviewImgVO reviewImgVO = new ReviewImgVO();
		reviewImgVO.setFileUuid(name);
		reviewImgVO.setReviewId(reviewId);
		reviewImgVO.setPath(path);
		reviewImgVO.setFname(img.getOriginalFilename());
		System.out.println(img.getOriginalFilename());
		reviewImgVO.setFsize(img.getSize());
		reviewImgVO.setFtype(img.getContentType());
		
		return reviewImgMapper.insertReviewImg(reviewImgVO);
	}
}
