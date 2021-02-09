package com.bangkoklab.ContractJob.service;

import java.util.List;

import com.bangkoklab.ContractJob.dto.Contract;

public interface ContractHandyService {

	public void RequestToHandy(Contract contract) throws Exception;
	
	// 핸디 자신의 모든 거래 요청 조회
	public List<Contract> findHandyReq(Contract contract) throws Exception;
	
	// 특정 일거리에 대한 핸디 자신의 모든 거래 요청 조회
	public List<Contract> FindHandyContract(Contract contract) throws Exception;
	
	
	
	// 이미 핸디에게 요청을 보냈는지 판단 => 이미 요청을 보냈으면 true, 아니면 false;
	public boolean isHandy(Contract contract) throws Exception;
	
}
