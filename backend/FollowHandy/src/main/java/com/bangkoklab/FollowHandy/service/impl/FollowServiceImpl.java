package com.bangkoklab.FollowHandy.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.bangkoklab.FollowHandy.dto.Handy;
import com.bangkoklab.FollowHandy.service.FollowService;

@Service
public class FollowServiceImpl implements FollowService {
	
	private static final String FOLLOW_HANDY = "FOLLOW_HANDY";
	
	@Autowired
	RedisTemplate<String, Object> redisTemplate;
	private HashOperations<String, String, List<Handy>> opsHashHandy;
	
	@PostConstruct
	private void init() {
		opsHashHandy = redisTemplate.opsForHash();
	}
	
	@Override
	public void FollowHandy(Handy handy) throws Exception {
		System.out.println(handy.getFollowId()+" *******");
		
		if(opsHashHandy.get(FOLLOW_HANDY, handy.getMyId())==null) {
			System.out.println("EMPTY!!!!!!!!!!!!!!!!!!!!!!!!");
			List<Handy> handies = new ArrayList<Handy>();
			handies.add(handy);
			opsHashHandy.put(FOLLOW_HANDY, handy.getMyId(), handies);
			
		}else {			
			List<Handy> handies = new ArrayList<Handy>();
			handies = opsHashHandy.get(FOLLOW_HANDY, handy.getMyId());			
			handies.add(handy);
			opsHashHandy.put(FOLLOW_HANDY, handy.getMyId(), handies);
		}
	}

	@Override
	public List<Handy> FindFollowHandy(String MyId) throws Exception {
		if(opsHashHandy.get(FOLLOW_HANDY, MyId)==null) {
			List<Handy> handies = new ArrayList<Handy>();
			return handies;
		}
		return opsHashHandy.get(FOLLOW_HANDY, MyId);
	}

	@Override
	public void deleteFollowById(Handy handy) throws Exception {
		List<Handy> handies = new ArrayList<Handy>();
		handies = opsHashHandy.get(FOLLOW_HANDY, handy.getMyId());
		
		String delFollowId = handy.getFollowId();
		for(int i = 0 ; i <handies.size();i++) {
			if(handies.get(i).getFollowId().equals(delFollowId)) {
				handies.remove(i);
				opsHashHandy.put(FOLLOW_HANDY, handy.getMyId(), handies);
				break;
			}
		}
	}

	@Override
	public boolean FindFollowById(Handy handy) throws Exception {
		List<Handy> handies = new ArrayList<Handy>();
		handies = opsHashHandy.get(FOLLOW_HANDY, handy.getMyId());
		String FollowId = handy.getFollowId();
		for(Handy temp : handies) {
			if(temp.getFollowId().equals(FollowId)) {
				return true;
			}
		}
		return false;
		
	}

}
