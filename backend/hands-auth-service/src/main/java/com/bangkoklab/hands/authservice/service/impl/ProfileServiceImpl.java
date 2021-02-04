package com.bangkoklab.hands.authservice.service.impl;

import com.bangkoklab.hands.authservice.data.entity.UserProfile;
import com.bangkoklab.hands.authservice.data.repository.AuthenticationRepository;
import com.bangkoklab.hands.authservice.data.repository.ProfileRepository;
import com.bangkoklab.hands.authservice.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements ProfileService {
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private AuthenticationRepository authenticationRepository;
    /**
    * @methodName selectProfile
    * @author parkjaehyun
    * @return com.bangkoklab.hands.authservice.data.entity.UserProfile
    * @description UUID 기반 프로필 조회
    **/
    @Override
    public UserProfile selectProfileByUserUuid(String userUuid) {
        return profileRepository.findByProfileId(authenticationRepository.findByUserUuid(userUuid).getUserProfile().getProfileId());
    }

    /**
    * @methodName selectAnotherProfile
    * @author parkjaehyun
    * @return com.bangkoklab.hands.authservice.data.entity.UserProfile
    * @description 누구에게나 공개되는 다른사람의 프로필 조회
    **/
    @Override
    public UserProfile selectAnotherProfile(String nickname) {
        return profileRepository.findByNickname(nickname);

    }

    /**
    * @methodName updateProfileByProfileId
    * @author parkjaehyun
    * @return com.bangkoklab.hands.authservice.data.entity.Authentication
    * @description 프로필 수정
    **/
    @Override
    public void updateProfileByProfileId(Long profileId, UserProfile newProfile) {
        UserProfile currentProfile=profileRepository.findByProfileId(profileId);
        currentProfile.setDescription(newProfile.getDescription());
        currentProfile.setGender(newProfile.getGender());
        currentProfile.setNickname(newProfile.getNickname());
        currentProfile.setPhone(newProfile.getPhone());
        currentProfile.setName(newProfile.getName());
        currentProfile.setAddress(newProfile.getAddress());
        profileRepository.save(currentProfile);
    }
}
