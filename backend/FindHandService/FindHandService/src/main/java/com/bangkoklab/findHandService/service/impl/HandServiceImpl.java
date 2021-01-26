package com.bangkoklab.findHandService.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bangkoklab.findHandService.data.dto.Hand;
import com.bangkoklab.findHandService.data.mapper.HandMapper;
import com.bangkoklab.findHandService.service.HandService;

@Service
public class HandServiceImpl implements HandService{

	@Autowired
	HandMapper mapper;
	@Override
	public List<Hand> findHands() throws Exception {
		return mapper.findHands();
	}

}
