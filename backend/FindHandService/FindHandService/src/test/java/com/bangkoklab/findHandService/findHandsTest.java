package com.bangkoklab.findHandService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bangkoklab.findHandService.controller.HandController;

/**
 *  모든 일거리 게시글 가져오기
 * */

public class findHandsTest extends ControllerTest{

	@Autowired
	private HandController handController;

	@Test
	@DisplayName("모든 일거리 게시글 가져옿기")
	public void simple() throws Exception {
		System.out.println("첫번째 테스트");
		mockMvc.perform(
				get("/hands/findHands")
				).andDo(print())
				.andExpect(status().isOk());
		// assertTrue("H".equals(handController.HandDeals()));
	}
	
	@Override
	protected Object controller() {
		return handController;
	}
}
