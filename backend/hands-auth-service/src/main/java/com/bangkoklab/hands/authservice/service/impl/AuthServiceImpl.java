package com.bangkoklab.hands.authservice.service.impl;

import com.bangkoklab.hands.authservice.data.entity.Authentication;
import com.bangkoklab.hands.authservice.data.repository.AuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
* @packageName com.bangkoklab.hands.authservice.service.impl
* @fileName AuthServiceImpl
* @author parkjaehyun
* @description 유저 인증 비즈니스 로직 수행 클래스
* @See UserDetailsService
**/
@Service
public class AuthServiceImpl implements UserDetailsService {
    @Autowired
    private AuthenticationRepository authenticationRepository;

    public Authentication join(Authentication auth){
        return authenticationRepository.save(auth);
    }

    public Authentication findByUserId(String userid) throws UsernameNotFoundException {
        return authenticationRepository.findByUserId(userid);
    }

    @Override
    public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException {
        return authenticationRepository.findByUserId(userid);
    }
}
