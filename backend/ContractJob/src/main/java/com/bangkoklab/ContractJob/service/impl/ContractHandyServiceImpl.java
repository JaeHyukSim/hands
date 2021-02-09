package com.bangkoklab.ContractJob.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.bangkoklab.ContractJob.dto.Contract;
import com.bangkoklab.ContractJob.service.ContractHandyService;

@Service
public class ContractHandyServiceImpl implements ContractHandyService {

	private static final String REQUEST_HANDY = "REQUEST_HANDY";
	private static final String HANDY_SEND = "HANDY_SEND"; // handy 가 요청한 거래
	private static final String HANDY_GET = "HANDY_GET"; // handy가 요청 받은 거래
	private static final String HANDER_SEND = "HANDER_SEND"; // hander 가 요청한 거래
	private static final String HANDER_GET = "HANDER_GET"; // hander가 요청 받은 거래

	@Autowired
	RedisTemplate<String, Object> redisTemplate;
	private HashOperations<String, String, List<Contract>> opsHashContract;

	@PostConstruct
	private void init() {
		opsHashContract = redisTemplate.opsForHash();
	}

	@Override
	public void RequestToHandy(Contract contract) throws Exception {
		if (opsHashContract.get(REQUEST_HANDY, contract.getContractJobId()) == null) {
			List<Contract> contracts = new ArrayList<Contract>();
			contracts.add(contract);
			opsHashContract.put(REQUEST_HANDY, contract.getContractJobId(), contracts);
		} else {
			List<Contract> contracts = new ArrayList<Contract>();
			contracts = opsHashContract.get(REQUEST_HANDY, contract.getContractJobId());
			contracts.add(contract);
			opsHashContract.put(REQUEST_HANDY, contract.getContractJobId(), contracts);
		}

		// 핸디 거래
		if (opsHashContract.get(HANDY_SEND, contract.getHandy()) == null) {
			List<Contract> contracts = new ArrayList<Contract>();
			contracts.add(contract);
			opsHashContract.put(HANDY_SEND, contract.getHandy(), contracts);
		} else {
			List<Contract> contracts = new ArrayList<Contract>();
			contracts = opsHashContract.get(HANDY_SEND, contract.getHandy());
			contracts.add(contract);
			System.out.println(contracts.get(0).getHandy());
			opsHashContract.put(HANDY_SEND, contract.getHandy(), contracts);
		}

		// 핸더 거래
		if (opsHashContract.get(HANDER_GET, contract.getHander()) == null) {
			List<Contract> contracts = new ArrayList<Contract>();
			contracts.add(contract);
			opsHashContract.put(HANDER_GET, contract.getHander(), contracts);
		} else {
			List<Contract> contracts = new ArrayList<Contract>();
			contracts = opsHashContract.get(HANDER_GET, contract.getHander());
			contracts.add(contract);
			opsHashContract.put(HANDER_GET, contract.getHander(), contracts);
		}
	}

	@Override
	public boolean isHandy(Contract contract) throws Exception {
		if (opsHashContract.get(REQUEST_HANDY, contract.getContractJobId()) == null) {
			return false;
		}

		List<Contract> contracts = new ArrayList<Contract>();
		contracts = opsHashContract.get(REQUEST_HANDY, contract.getContractJobId());

		for (Contract temp : contracts) {
			if (temp.getHander().equals(contract.getHander())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public List<Contract> findHandyReq(Contract contract) throws Exception {
		return opsHashContract.get(HANDY_SEND, contract.getHandy());
	}

	@Override
	public List<Contract> FindHandyContract(Contract contract) throws Exception {
		return opsHashContract.get(REQUEST_HANDY, contract.getContractJobId());
	}

	@Override
	public void delContractHandy(Contract contract) throws Exception {
		String delId = contract.getHander();
		List<Contract> job = opsHashContract.get(REQUEST_HANDY, contract.getContractJobId());
		List<Contract> id = opsHashContract.get(HANDY_SEND, contract.getHandy());
		List<Contract> get = opsHashContract.get(HANDER_GET, contract.getHander());

		for (int i = 0; i < job.size(); i++) {
			if (job.get(i).getHander().equals(delId)) {
				job.remove(i);
				opsHashContract.put(REQUEST_HANDY, contract.getContractJobId(), job);
				break;
			}
		}

		for (int i = 0; i < id.size(); i++) {
			if (id.get(i).getHander().equals(delId)) {
				id.remove(i);
				opsHashContract.put(HANDY_SEND, contract.getHandy(), id);
				break;
			}
		}

		for (int i = 0; i < get.size(); i++) {
			if (get.get(i).getHander().equals(delId)) {
				get.remove(i);
				opsHashContract.put(HANDER_GET, contract.getHander(), get);
				break;
			}
		}
	}

	public List<Contract> findHandyGet(Contract contract) throws Exception {
		return opsHashContract.get(HANDY_GET, contract.getHandy());
	}

	public void delHandyGet(Contract contract) throws Exception {
		String delId = contract.getHander();
		List<Contract> job = opsHashContract.get(REQUEST_HANDY, contract.getContractJobId());
		List<Contract> id = opsHashContract.get(HANDY_GET, contract.getHandy());
		List<Contract> get = opsHashContract.get(HANDER_SEND, contract.getHander());

		for (int i = 0; i < job.size(); i++) {
			if (job.get(i).getHander().equals(delId)) {
				job.remove(i);
				opsHashContract.put(REQUEST_HANDY, contract.getContractJobId(), job);
				break;
			}
		}

		for (int i = 0; i < id.size(); i++) {
			if (id.get(i).getHander().equals(delId)) {
				id.remove(i);
				opsHashContract.put(HANDY_GET, contract.getHandy(), id);
				break;
			}
		}

		for (int i = 0; i < get.size(); i++) {
			if (get.get(i).getHander().equals(delId)) {
				get.remove(i);
				opsHashContract.put(HANDER_SEND, contract.getHander(), get);
				break;
			}
		}
	}

}
