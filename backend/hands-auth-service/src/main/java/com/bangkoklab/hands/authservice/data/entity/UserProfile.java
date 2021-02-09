package com.bangkoklab.hands.authservice.data.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Map;

/**
* @packageName com.bangkoklab.hands.authservice.data.entity
* @fileName UserProfile
* @author parkjaehyun
* @description 유저 프로필 엔티티 클래스
**/
@Entity
@Getter
@Setter
public class UserProfile {
    @Id
    @GeneratedValue
    @Column(name = "profile_id")
    private Long profileId;
    private String userUuid;
    private String email;
    private String name;
    private String phone;
    private String address;
    private String gender;
    private String description;
    private String nickname;
    private int type;
    public void setProfileByParams(Map<String, String> params){
        this.setEmail(params.get("email"));
        this.setName(params.get("name"));
        this.setPhone(params.get("phone"));
        this.setAddress(params.get("address"));
        this.setGender(params.get("gender"));
        this.setDescription(params.get("description"));
        this.setNickname(params.get("nickname"));
        this.setType(Integer.parseInt(params.get("type")));
    }
}
