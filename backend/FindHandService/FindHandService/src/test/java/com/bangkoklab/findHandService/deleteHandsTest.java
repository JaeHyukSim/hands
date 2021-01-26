package com.bangkoklab.findHandService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import com.bangkoklab.findHandService.controller.HandController;
import com.bangkoklab.findHandService.data.dto.Hand;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *  모든 일거리 게시글 가져오기
 * */

public class deleteHandsTest extends ControllerTest{

	@Autowired
	private HandController handController;
	@Autowired
	private ObjectMapper objectMapper;
	
	@Test
	@DisplayName("일거리 게시글 삭제")
	public void deleteHandDealTest() throws Exception {
		System.out.println("첫번째 테스트");
		
		Hand hand = new Hand();
		hand.setJobId("12345");
		String content = objectMapper.writeValueAsString(hand);
		
		mockMvc.perform(
				delete("/hands/deleteHand")
				.content(content)
				.contentType(MediaType.APPLICATION_JSON)
				).andDo(print())
				.andExpect(status().isOk());
		// assertTrue("H".equals(handController.HandDeals()));
	}
	
	@Override
	protected Object controller() {
		return handController;
	}
}
