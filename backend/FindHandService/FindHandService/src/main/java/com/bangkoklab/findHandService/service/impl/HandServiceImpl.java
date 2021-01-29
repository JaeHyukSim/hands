package com.bangkoklab.findHandService.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bangkoklab.findHandService.data.dto.Category;
import com.bangkoklab.findHandService.data.dto.Hand;
import com.bangkoklab.findHandService.data.dto.Credit;
import com.bangkoklab.findHandService.data.mapper.FindHandMapper;
import com.bangkoklab.findHandService.data.mapper.HandMapper;
import com.bangkoklab.findHandService.service.HandService;

@Service
public class HandServiceImpl implements HandService{

	@Autowired
	HandMapper mapper;
	@Autowired
	FindHandMapper Findmapper;
	
	@Override
	public void insertHand(Hand hand) throws Exception {
		mapper.insertHand(hand);
	}

	@Override
	public void deleteHand(Hand hand) throws Exception {
		mapper.deleteHand(hand);
	}

	@Override
	public void updateHand(Hand hand) throws Exception {
		mapper.updateHand(hand);
	}

	@Override
	public List<Hand> findHands() throws Exception {
		return Findmapper.findHands();
	}
	
	@Override
	public List<Hand> findByCategoryHands(Category category) throws Exception {
		return Findmapper.findByCategory(category);
	}

	@Override
	public List<Hand> findByDong(String dong) throws Exception {
		return Findmapper.findByDong(dong);
	}

	@Override
	public List<Hand> downCredit() throws Exception {
		return Findmapper.downCredit();
	}

	@Override
	public List<Hand> upCredit() throws Exception {
		// TODO Auto-generated method stub
		return Findmapper.upCredit();
	}

	@Override
	public List<Hand> findByCreditHands(Credit credit) throws Exception {
		return Findmapper.findByCredit(credit);
	}

	@Override
	public List<Hand> findByTimeHand(int day) throws Exception {
		return Findmapper.findByTimeHand(day);
	}

	@Override
	public void deletOverDayeHand() throws Exception {
		mapper.deletOverDayeHand();
	}

	

}
