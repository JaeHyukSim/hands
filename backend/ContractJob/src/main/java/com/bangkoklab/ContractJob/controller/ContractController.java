package com.bangkoklab.ContractJob.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bangkoklab.ContractJob.dto.Contract;
import com.bangkoklab.ContractJob.service.ContractService;

@RestController
public class ContractController {

	@Autowired
	ContractService service;
	// handy에게 거래 요청
	@PostMapping("/requestToHandy")
	public ResponseEntity<Map<String,Object>> RequestToHandy(@RequestBody Contract contract){
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;

		// 중복 방지를 위하여
		try {
			if(service.isHandy(contract)) {
				resultMap.put("message", "Exist");  //해당 핸디에게 이미 요청을 보냈다
				status = HttpStatus.OK;
				return new ResponseEntity<Map<String, Object>>(resultMap, status);
			}
			
			
			contract.setContractId(UUID.randomUUID().toString());
			contract.setHandyStatus("YES");
			contract.setHanderStatus("NO");
			contract.setContractStatus("BEFORE");
			service.RequestToHandy(contract);
			resultMap.put("message", "success");
			status = HttpStatus.OK;
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("message", "fail");
			status = HttpStatus.ACCEPTED;
		}
		
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
	// hander에게 거래요청
	
	// handy 자신에게 온 모든 요청 조회
	
	// hander 자신에게 온 모든 요청 조회
	
	// 특정 hander에게 거래요청을 했는지 판단
	
	// 특정  handy에게 거래요청 했는지 판단
}
   