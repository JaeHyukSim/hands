package com.bangkoklab.hands.authservice.service.impl;

import com.bangkoklab.hands.authservice.data.entity.Authentication;
import com.bangkoklab.hands.authservice.data.repository.AuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaSystemException;
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
    private static final String EMAIL_PATTERN = "([\\w.])(?:[\\w.]*)(@.*)";
    @Autowired
    private AuthenticationRepository authenticationRepository;
    /**
     * @methodName join
     * @author parkjaehyun
     * @param
     * @return com.bangkoklab.hands.authservice.data.entity.Authentication
     * @description 회원가입
     **/
    public Authentication join(Authentication auth){
        try{
            return authenticationRepository.save(auth);
        }catch(JpaSystemException e){
            // 로직이 제대로 수행되지 않았을때
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @methodName findByUserId
     * @author parkjaehyun
     * @param
     * @return com.bangkoklab.hands.authservice.data.entity.Authentication
     * @description ID로 유저 찾기
     **/
    public Authentication findUserByUserId(String userId) throws UsernameNotFoundException {
        return authenticationRepository.findByUserId(userId);
    }

    /**
     * @methodName findUserByUserUuid
     * @author parkjaehyun
     * @return com.bangkoklab.hands.authservice.data.entity.Authentication
     * @description UserUUID로 유저 인증정보 찾기
     **/
    public Authentication findUserByUserUuid(String userUuid) throws UsernameNotFoundException {
        return authenticationRepository.findByUserUuid(userUuid);
    }

    /**
    * @methodName loadUserByUsername
    * @author parkjaehyun
    * @param
    * @return org.springframework.security.core.userdetails.UserDetails
    * @description 유저 아이디로 유저 찾기
    * @See org.springframework.security.core.UserDetailService
    **/
    @Override
    public UserDetails loadUserByUsername(String userUuid) throws UsernameNotFoundException {
        return authenticationRepository.findByUserUuid(userUuid);
    }

    public String findUserByProfileId(String profileId){
        Authentication findAuth=authenticationRepository.findByProfileId(profileId);
        return findAuth.getUserId().replaceAll(EMAIL_PATTERN,"$1****$2");
    }

}
