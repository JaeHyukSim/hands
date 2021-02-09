package com.bangkoklab.ContractJob.service;


import com.bangkoklab.ContractJob.dto.Contract;

public interface ContractHanderService {

	public void RequestToHander(Contract contract) throws Exception;
	
	
	
	// 이미 핸더에게 요청을 보냈는지 판단 => 이미 요청을 보냈으면 true, 아니면 false;
	public boolean isHander(Contract contract) throws Exception;
}
