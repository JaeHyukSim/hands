package com.bangkoklab.FollowHandy.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bangkoklab.FollowHandy.dto.Handy;
import com.bangkoklab.FollowHandy.service.FollowService;

@RestController
public class FollowController {

	@Autowired
	FollowService service;
	
	@PostMapping("/follow")
	public ResponseEntity<Map<String, Object>> FpllowHandy(@RequestBody Handy handy) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;

		try {
			service.FollowHandy(handy);
			resultMap.put("message", "success");
			status = HttpStatus.OK;
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("message", "fail");
			status = HttpStatus.ACCEPTED;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
	@GetMapping("/findFollow")
	public ResponseEntity<List<Handy>> FindFollow(@RequestBody Handy handy) throws Exception{
		return new ResponseEntity<List<Handy>>(service.FindFollowHandy(handy), HttpStatus.OK);
	}
}
