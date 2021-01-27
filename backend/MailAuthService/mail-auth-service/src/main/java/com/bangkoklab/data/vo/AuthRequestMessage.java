/**
 * content : 인증 코드를 클라이언트에게 제공할 때 return하는 vo입니다. 
 */


package com.bangkoklab.data.vo;

public class AuthRequestMessage {
	private String answer;

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public AuthRequestMessage() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "AuthRequestMessage [answer=" + answer + "]";
	}

}
