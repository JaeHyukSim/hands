package com.bangkoklab.service.impl;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bangkoklab.data.repository.mapper.ReviewImgMapper;
import com.bangkoklab.data.vo.ImgOfOutput;
import com.bangkoklab.data.vo.ReviewImgVO;
import com.bangkoklab.service.ImgService;

import net.coobird.thumbnailator.Thumbnails;

/**
 * @packageName com.bangkoklab.service.impl
 * @fileName ImgServiceImpl
 * @author shimjaehyuk
 * @description review 내의 이미지 서비스
 * @See ImgService
 **/
@Service
public class ImgServiceImpl implements ImgService {

	@Autowired
	ReviewImgMapper reviewImgMapper;
	
    /**
     * @methodName saveToServer
     * @author shimjaehyuk
     * @param	List<MultipartFile> imgs, String reviewId
     * @return int
     * @description 이미지 서버에 저장
     **/
	public int saveToServer(List<MultipartFile> imgs, String reviewId) {
		Date today = new Date();
		SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
		SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
		SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
		String year = yearFormat.format(today);
		String month = monthFormat.format(today);
		String day = dayFormat.format(today);
		if(imgs == null) return 1;
		for (MultipartFile img : imgs) {
			String uuid = UUID.randomUUID().toString();
			String orgName = img.getOriginalFilename();
			int index = orgName.lastIndexOf(".");
			String ext = "";
			if(index != -1) {
				ext = orgName.substring(index);
			}
			
			//윈도우 local
			String path = "C:/hands/uploads/" + year + "/" + month + "/" + day;
			//리눅스 local
//			String path = "home/hands/uploads/" + year + "/" + month + "/" + day;
			
			String name = uuid + ext;
			File file = new File(path, name);
			file.mkdirs();
			try {
				insertImgs(name, path, img, reviewId);
				img.transferTo(file);
				if(img.getContentType().startsWith("image/")) {
					Thumbnails.of(file) // file 파일을 기반으로 해서 만든다.
							  .size(400,200)
							  .toFile(new File(file.getParent(),"thumb_" + name));
				}
			} catch (Exception e) {
				e.printStackTrace();
				return 0;
			}
		}
		return 1;
	}
	
    /**
     * @methodName insertImgs
     * @author shimjaehyuk
     * @param	String name, String path, MultipartFile img, String reviewId
     * @return int
     * @description 디비에 이미지 저장 서비스
     **/
	public int insertImgs(String name, String path, MultipartFile img, String reviewId) throws Exception{
		ReviewImgVO reviewImgVO = new ReviewImgVO();
		reviewImgVO.setFileUuid(name);
		reviewImgVO.setReviewId(reviewId);
		reviewImgVO.setPath(path);
		reviewImgVO.setFname(img.getOriginalFilename());
		reviewImgVO.setFsize(img.getSize());
		reviewImgVO.setFtype(img.getContentType());
		
		return reviewImgMapper.insertReviewImg(reviewImgVO);
	}
	
    /**
     * @methodName getImgByReviewId
     * @author shimjaehyuk
     * @param	String reviewId
     * @return List<ImgOfOutput>
     * @description 리뷰에 대한 이미지들 제공 서비스
     **/
	public List<ImgOfOutput> getImgByReviewId(String reviewId) {
		List<ImgOfOutput> res = new ArrayList<ImgOfOutput>();
		List<ReviewImgVO> imgs = reviewImgMapper.getImgByReviewId(reviewId);
		if(imgs == null) return null;
		
		for(ReviewImgVO img : imgs) {
			File originImg = new File(img.getPath(),img.getFileUuid());
			File thumbnail = new File(img.getPath(),"thumb_" + img.getFileUuid());
			String name = img.getFname();
			long fileSize = img.getFsize();
			String fileType= img.getFtype();
			
			ImgOfOutput imgOfOutput = new ImgOfOutput(originImg,thumbnail,name,reviewId,fileSize,fileType);
			res.add(imgOfOutput);
		}
		return res;
	}
	
    /**
     * @methodName deleteImg
     * @author shimjaehyuk
     * @param	String reviewId
     * @return int
     * @description 리뷰에 대한 이미지들 삭제 서비스
     **/
	public int deleteImg(String reviewId) throws Exception {
		return reviewImgMapper.deleteImg(reviewId);
	}
}
