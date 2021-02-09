package com.bangkoklab.ContractJob;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import com.bangkoklab.ContractJob.controller.ContractController;
import com.bangkoklab.ContractJob.dto.Contract;
import com.fasterxml.jackson.databind.ObjectMapper;

public class requestToHandyTest extends ControllerTest {

	@Autowired
	private ContractController controller;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Test
	@DisplayName("핸디에게 요청하기")
	public void requestToHandy() throws Exception {
		Contract contract = new Contract();
		contract.setContractJobId("777");
		contract.setHander("run6722");
		contract.setHandy("MOUSE1");
		String content = objectMapper.writeValueAsString(contract);
		mockMvc.perform(
				post("/requestToHandy")
				.content(content)
				.contentType(MediaType.APPLICATION_JSON)
				).andDo(print())
				.andExpect(status().isOk());
		
	}
	@Override
	protected Object controller() {
		// TODO Auto-generated method stub
		return controller;
	}

}
