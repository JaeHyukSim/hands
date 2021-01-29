package com.bangkoklab.findHandService.data.mapper;

import java.util.List;

import com.bangkoklab.findHandService.data.dto.Category;
import com.bangkoklab.findHandService.data.dto.Hand;

public interface HandMapper {
	void insertHand(Hand hand) throws Exception;
	void deleteHand(Hand hand) throws Exception;
	void updateHand(Hand hand) throws Exception;
	void deletOverDayeHand() throws Exception;
}
