package com.bangkoklab.FollowHandy;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import com.bangkoklab.FollowHandy.controller.FollowController;
import com.bangkoklab.FollowHandy.dto.Handy;
import com.fasterxml.jackson.databind.ObjectMapper;

public class deleteFollowHandyByIdTest extends ControllerTest {

	
	@Autowired
	private FollowController followController;
	@Autowired
	private ObjectMapper objectMapper;
	
	@Test
	@DisplayName("팔로우 하는 특정 사람 정보 삭제")
	public void FindFollowHandy() throws Exception{
		Handy handy = new Handy();
		handy.setMyId("run6722@naver.com");
		handy.setFollowId("winmo95@gmail.com");
		String content = objectMapper.writeValueAsString(handy);
		
		mockMvc.perform(
				delete("/deleteFollowById")
				.content(content)
				.contentType(MediaType.APPLICATION_JSON)
				).andDo(print())
				.andExpect(status().isOk());
	}
	
	@Override
	protected Object controller() {
		return followController;
	}

}
