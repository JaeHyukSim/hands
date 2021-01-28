package com.bangkoklab.findHandService.data.mapper;

import java.util.List;

import com.bangkoklab.findHandService.data.dto.Category;
import com.bangkoklab.findHandService.data.dto.Hand;

public interface FindHandMapper {
	List<Hand> findHands() throws Exception;
	List<Hand> findByCategory(Category category) throws Exception;
}
