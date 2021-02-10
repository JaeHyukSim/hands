package com.bangkoklab.FollowHandy.service;

import java.util.List;

import com.bangkoklab.FollowHandy.dto.Handy;

public interface FollowService {
	public void FollowHandy(Handy handy) throws Exception;
	List<Handy> FindFollowHandy(String MyId) throws Exception;
	void deleteFollowById(Handy handy) throws Exception;
	boolean FindFollowById(Handy handy) throws Exception;
}
