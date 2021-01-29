package com.bangkoklab.findHandService.data.mapper;

import java.util.List;

import com.bangkoklab.findHandService.data.dto.Category;
import com.bangkoklab.findHandService.data.dto.Credit;
import com.bangkoklab.findHandService.data.dto.Hand;

public interface FindHandMapper {
	List<Hand> findHands() throws Exception;
	List<Hand> findByCategory(Category category) throws Exception;
	List<Hand> findByDong(String dong) throws Exception;
	List<Hand> downCredit() throws Exception;
	List<Hand> upCredit() throws Exception;
	List<Hand> findByCredit(Credit credit) throws Exception;
	List<Hand> findByTimeHand(int day) throws Exception;
	
}
