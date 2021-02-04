package com.bangkoklab.hands.authservice.service;

import com.bangkoklab.hands.authservice.data.entity.UserProfile;

/**
* @packageName com.bangkoklab.hands.authservice.service
* @fileName ProfileService
* @author parkjaehyun
* @description 프로필 관련 서비스
**/
public interface ProfileService {
    // 프로필 조회
    UserProfile selectProfileByUserUuid(String userUuid);
    // 다른사람의 프로필 조회
    UserProfile selectAnotherProfile(String nickname);
    // 프로필 변경
    void updateProfileByProfileId(Long profileId,UserProfile newProfile);
}
