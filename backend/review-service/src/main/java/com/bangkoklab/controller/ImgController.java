package com.bangkoklab.controller;

import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bangkoklab.service.ImgService;

@RestController
public class ImgController {

	@Autowired
	ImgService imgService;

	@GetMapping(value = "image/{imagename}")
	public ResponseEntity<?> getImg(@PathVariable("imagename") String imgName) {

		MultiValueMap<String, String> header = new LinkedMultiValueMap<>();

		try {
			String path = imgService.getPath(imgName);
			if (path == null) {
				header.add("message", "no image");
				return new ResponseEntity<>(header, HttpStatus.NO_CONTENT);
			}
			
			System.out.println("path + imgName : " + path + imgName);
			InputStream imgStream = new FileInputStream(path + imgName);
			System.out.println("imgStream : " + imgStream);
			byte[] imgByteArray = IOUtils.toByteArray(imgStream);
			imgStream.close();
			header.add("message", "img ok");
			return new ResponseEntity<byte[]>(imgByteArray,header,HttpStatus.OK);
		} catch (Exception e) {
			header.add("message", "path error");
			header.add("content-type", "application/any");
			return new ResponseEntity<>(header, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
