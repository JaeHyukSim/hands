package com.bangkoklab.ContractJob.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContractController {

	@PostMapping("/requestToHandy")
	public ResponseEntity<Map<String,Object>> RequestToHandy(@RequestParam String TEST){
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		System.out.println(TEST);
		resultMap.put("message", "success");
		status = HttpStatus.OK;
		
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
}
