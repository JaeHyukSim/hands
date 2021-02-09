package com.bangkoklab.ContractJob.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bangkoklab.ContractJob.dto.Contract;
import com.bangkoklab.ContractJob.service.ContractHanderService;

@RestController
public class ContractHanderController {

	@Autowired
	ContractHanderService Handerservice;

	// handy에게 거래 요청
	@PostMapping("/requestByHander")
	public ResponseEntity<Map<String, Object>> requestToHander(@RequestBody Contract contract) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;

		// 중복 방지를 위하여
		try {
			if (Handerservice.isHander(contract)) {
				resultMap.put("message", "Exist"); // 해당 핸더에게 이미 요청을 보냈다
				status = HttpStatus.OK;
				return new ResponseEntity<Map<String, Object>>(resultMap, status);
			}
			contract.setContractId(UUID.randomUUID().toString());
			contract.setHandyStatus("NO");
			contract.setHanderStatus("YES");
			contract.setContractStatus("BEFORE");
			Handerservice.RequestToHander(contract);
			resultMap.put("message", "success");
			status = HttpStatus.OK;
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("message", "fail");
			status = HttpStatus.ACCEPTED;
		}

		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}

	// handy 자신이 요청한 모든 거래 조회
	@GetMapping("/findHanderReq")
	public ResponseEntity<List<Contract>> getHandy(@RequestBody Contract contract) throws Exception {
		System.out.println(contract.getHandy());
		return new ResponseEntity<List<Contract>>(Handerservice.FindHanderContract(contract), HttpStatus.OK);
	}
}
