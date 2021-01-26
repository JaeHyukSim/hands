package com.bangkoklab.findHandService.data.mapper;

import java.util.List;

import com.bangkoklab.findHandService.data.dto.Hand;

public interface HandMapper {
	List<Hand> findHands() throws Exception;
	void insertHand(Hand hand) throws Exception;
	void deleteHand(Hand hand) throws Exception;
}
