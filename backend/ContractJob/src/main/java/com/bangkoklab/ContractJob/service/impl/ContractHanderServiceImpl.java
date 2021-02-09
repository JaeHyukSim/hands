package com.bangkoklab.ContractJob.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.bangkoklab.ContractJob.dto.Contract;
import com.bangkoklab.ContractJob.service.ContractHanderService;

@Service
public class ContractHanderServiceImpl implements ContractHanderService {
	
	private static final String REQUEST_HANDER = "REQUEST_HANDER";
	@Autowired
	RedisTemplate<String, Object> redisTemplate;
	private HashOperations<String, String, List<Contract>> opsHashContract;
	
	@PostConstruct
	private void init() {
		opsHashContract = redisTemplate.opsForHash();
	}

	@Override
	public void RequestToHander(Contract contract) throws Exception {
		if(opsHashContract.get(REQUEST_HANDER, contract.getContractJobId())==null) {
			List<Contract> contracts = new ArrayList<Contract>();
			contracts.add(contract);
			opsHashContract.put(REQUEST_HANDER, contract.getContractJobId(), contracts);
		}else {
			List<Contract> contracts = new ArrayList<Contract>();
			contracts = opsHashContract.get(REQUEST_HANDER, contract.getContractJobId());
			contracts.add(contract);
			opsHashContract.put(REQUEST_HANDER, contract.getContractJobId(), contracts);
		}
		
		List<Contract> contracts = new ArrayList<Contract>();
		contracts = opsHashContract.get(REQUEST_HANDER, contract.getContractJobId());
		System.out.println("------------------------");
		for(Contract temp : contracts) {
			System.out.println(temp.getContractId());
			System.out.println(temp.getContractJobId());
			System.out.println(temp.getHandy());
			System.out.println(temp.getHander());
			System.out.println(temp.getHandyStatus());
			System.out.println(temp.getHanderStatus());
			System.out.println(temp.getContractStatus());
			System.out.println("-----------------------");
		}
	}

	@Override
	public boolean isHander(Contract contract) throws Exception {
		if(opsHashContract.get(REQUEST_HANDER, contract.getContractJobId())==null) {
			return false;
		}
		
		List<Contract> contracts = new ArrayList<Contract>();
		contracts = opsHashContract.get(REQUEST_HANDER, contract.getContractJobId());

		for(Contract temp : contracts) {
			if(temp.getHandy().equals(contract.getHandy())) {
				return true;
			}
		}
		return false;
	}

}
