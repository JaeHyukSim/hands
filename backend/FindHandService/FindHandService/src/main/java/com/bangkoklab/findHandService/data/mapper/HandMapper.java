package com.bangkoklab.findHandService.data.mapper;

import java.util.List;

import com.bangkoklab.findHandService.data.dto.Hand;

public interface HandMapper {
	List<Hand> findHands() throws Exception;
}
