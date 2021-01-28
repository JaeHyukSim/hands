package com.bangkoklab.findHandService.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bangkoklab.findHandService.data.dto.Category;
import com.bangkoklab.findHandService.data.dto.Hand;
import com.bangkoklab.findHandService.service.HandService;

@RestController
@RequestMapping("/hands")
public class HandController {
	
	@Autowired
	HandService service;

//	입력후 리스트 출력
//	@PostMapping("/insertHand")
//	public ResponseEntity<List<Hand>> insertHand(@RequestBody Hand hand) throws Exception{
//		service.insertHand(hand);
//		return new ResponseEntity<List<Hand>>(service.findHands(),HttpStatus.OK);
//	}

	// 일거리 게시
	// 기본키 중복 예외
	@PostMapping("/insertHand")
	public ResponseEntity<Map<String, Object>> insertHand(@RequestBody Hand hand){
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		
		try {
			service.insertHand(hand);
			resultMap.put("message", "success");
			status = HttpStatus.OK;
		} catch (Exception e) {
			resultMap.put("message", "fail");
			status = HttpStatus.ACCEPTED;
		}
		return  new ResponseEntity<Map<String, Object>>(resultMap,status);
	}
	
	// 일거리 조회
	@GetMapping("/findHands")
	public ResponseEntity<List<Hand>> HandDeals() throws Exception{
		return new ResponseEntity<List<Hand>>(service.findHands(),HttpStatus.OK);
	}
	
	// 카테고리 별 일거리 조회
	@GetMapping("/findHandsByCategory")
	public ResponseEntity<List<Hand>> findByCategory(@RequestBody Category category) throws Exception{
		try {			
			System.out.println(category.getCategoryName());
			service.findByCategoryHands(category);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<List<Hand>>(service.findByCategoryHands(category),HttpStatus.OK);
	}
	
	// 동별 일거리 조회
	@GetMapping("/findHandsByDong")
	public ResponseEntity<List<Hand>> findByCategory(@RequestParam String dong) throws Exception{
		try {			
			service.findByDong(dong);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<List<Hand>>(service.findByDong(dong),HttpStatus.OK);
	}
	
	//일거리 삭제
	@DeleteMapping("deleteHand")
	public ResponseEntity<Map<String, Object>> deleteHand(@RequestBody Hand hand) throws Exception{
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		
		try {
			service.deleteHand(hand);
			resultMap.put("message", "success");
			status = HttpStatus.OK;
		} catch (Exception e) {
			resultMap.put("message", "fail");
			status = HttpStatus.ACCEPTED;
		}
		return  new ResponseEntity<Map<String, Object>>(resultMap,status);
	}
	
	//일거리 수정
	@PutMapping("/updateHand")
	public ResponseEntity<Map<String, Object>> UpdateHand(@RequestBody Hand hand){
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		System.out.println(hand.getJobId());
		try {
			service.updateHand(hand); 
			resultMap.put("message", "success");
			status = HttpStatus.OK;
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("message", "fail");
			status = HttpStatus.ACCEPTED;
		}
		return  new ResponseEntity<Map<String, Object>>(resultMap,status);
	}
	
}
