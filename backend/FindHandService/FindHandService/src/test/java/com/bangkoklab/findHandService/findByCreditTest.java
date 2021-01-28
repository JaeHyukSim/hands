package com.bangkoklab.findHandService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import com.bangkoklab.findHandService.controller.HandController;
import com.bangkoklab.findHandService.data.dto.Category;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *  모든 일거리 게시글 가져오기
 * */

public class findByCreditTest extends ControllerTest{

	@Autowired
	private HandController handController;
	@Test
	@DisplayName("크레딧 별 정렬")
	public void simple() throws Exception {
		mockMvc.perform(
				get("/hands/SortByCredit")
				.param("order","up")
				).andDo(print())
				.andExpect(status().isOk());
		// assertTrue("H".equals(handController.HandDeals()));
	}
	
	@Override
	protected Object controller() {
		return handController;
	}
}
