package com.bangkoklab.findHandService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import com.bangkoklab.findHandService.controller.HandController;
import com.bangkoklab.findHandService.data.dto.Hand;
import com.fasterxml.jackson.databind.ObjectMapper;

public class updateHandTest extends ControllerTest {
	@Autowired
	private HandController handController;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Test
	@DisplayName("일거리 게시글 수정")
	public void insertHandDealTest() throws Exception {
		Hand hand = new Hand();
		hand.setJobId("1234");
		hand.setJobUserUUid("1248657498sdgadsag");
		hand.setCategoryId("배달");
		hand.setContent("택배 수령해서 내장고에 보관해주세요");
		SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
		Date time = new Date();
		String time1 = format1.format(time);
		
		hand.setJobRegdate(time);
		hand.setWorkingHour("15");
		hand.setJobCredit("3000");
		hand.setWorkingDate("2021-01-25");
		hand.setWorkingAddress("언양 진장길");
		hand.setStatus("거래중");
		String content = objectMapper.writeValueAsString(hand);
		
		mockMvc.perform(
				put("/hands/updateHand")
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
