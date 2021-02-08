package com.bangkoklab.FollowHandy.dto;

import java.io.Serializable;

public class Handy implements Serializable {
	private String MyId;
	private String FollowId;
	public String getMyId() {
		return MyId;
	}
	public void setMyId(String myId) {
		MyId = myId;
	}
	public String getFollowId() {
		return FollowId;
	}
	public void setFollowId(String followId) {
		FollowId = followId;
	}

		
}
