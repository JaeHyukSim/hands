package com.bangkoklab.findHandService.service;

import java.util.List;

import com.bangkoklab.findHandService.data.dto.Category;
import com.bangkoklab.findHandService.data.dto.Hand;
import com.bangkoklab.findHandService.data.dto.Credit;

public interface HandService {
	void insertHand(Hand hand) throws Exception;
	void deleteHand(Hand hand) throws Exception;
	void updateHand(Hand hand) throws Exception;
	void deletOverDayeHand() throws Exception;
	List<Hand> findHands() throws Exception;
	List<Hand> findByCategoryHands(Category category) throws Exception;
	List<Hand> findByDong(String dong) throws Exception;
	List<Hand> downCredit() throws Exception;
	List<Hand> upCredit() throws Exception;
	List<Hand> findByCreditHands(Credit credit) throws Exception;
	List<Hand> findByTimeHand(int day) throws Exception;
}
