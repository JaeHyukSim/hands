package com.bangkoklab.findJobService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import com.bangkoklab.findJobService.controller.JobController;
import com.bangkoklab.findJobService.data.dto.Credit;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *  모든 일거리 게시글 가져오기
 * */

public class findByCreditTest extends ControllerTest{

	@Autowired
	private JobController handController;
	@Autowired
	private ObjectMapper objectMapper;
	@Test
	@DisplayName("크레딧 범위 조회")
	public void simple() throws Exception {
		Credit credit = new Credit();
		credit.setMinCredit("2000");
		credit.setMaxCredit("3000");
		String content = objectMapper.writeValueAsString(credit);
		mockMvc.perform(
				get("/Jobs/findJobsByCredit")
				.param("minValue","3000")
				.param("maxValue","4500")
				).andDo(print())
				.andExpect(status().isOk());
		// assertTrue("H".equals(handController.HandDeals()));
	}
	
	@Override
	protected Object controller() {
		return handController;
	}
}
