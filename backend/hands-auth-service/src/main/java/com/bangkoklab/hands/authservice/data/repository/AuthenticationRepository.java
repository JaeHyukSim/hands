package com.bangkoklab.hands.authservice.data.repository;

import com.bangkoklab.hands.authservice.data.entity.Authentication;
import org.springframework.data.jpa.repository.JpaRepository;

/**
* @packageName com.bangkoklab.hands.authservice.data.repository
* @fileName AuthenticationRepository
* @author parkjaehyun
* @description 인증 레포지토리 클래스
**/
public interface AuthenticationRepository extends JpaRepository<Authentication,Long> {
    Authentication findByUserId(String userId);

}