package com.bangkoklab.hands.authservice.controller;

import com.bangkoklab.hands.authservice.common.JwtTokenProvider;
import com.bangkoklab.hands.authservice.data.entity.Authentication;
import com.bangkoklab.hands.authservice.data.entity.UserProfile;
import com.bangkoklab.hands.authservice.service.impl.AuthServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
* @packageName com.bangkoklab.hands.authservice.controller
* @fileName AuthController
* @author parkjaehyun
* @description
 * 인증 관련 작업 요청을 받고 response 하는 인증 주체 컨트롤러
**/
@RestController
public class AuthController {
    @Autowired
    private AuthServiceImpl authService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    /**
     * @methodName join
     * @author parkjaehyun
     * @param Map<String, String> join시 필요한 params map
     * @return org.springframework.http.ResponseEntity<?>
     * @description 회원가입시 기본 profile과 함께 유저 등록
     **/
    @PostMapping("/join")
    public ResponseEntity<?> join(@RequestBody Map<String, String> param) {
        Authentication auth=new Authentication();
        MultiValueMap<String, String> header = new LinkedMultiValueMap<>();
        UserProfile profile=new UserProfile();
        profile.setProfileByParams(param);
        auth.setUserId(param.get("userId"));
        auth.setPassword(passwordEncoder.encode(param.get("password")));
        auth.setUserUuid(UUID.randomUUID().toString().replace("-",""));
        auth.addAuthorities("ROLE_USER");
        auth.setUserProfile(profile);
        if(null!=authService.join(auth)){
            header.add("message","회원가입성공");
            return new ResponseEntity<>(header, HttpStatus.OK);
        }else {
            header.add("message", "회원가입 실패");
            return new ResponseEntity<>(header, HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * @methodName login
     * @author parkjaehyun
     * @param
     * @return org.springframework.http.ResponseEntity<?>
     * @description 로그인 성공시 response header에 토큰과 body에 userUuid,profileId를 반환함
     **/
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String,String> params){
        MultiValueMap<String, String> header = new LinkedMultiValueMap<>();
        Map<String, String> body = new HashMap<>();
        Authentication authentication = authService.findUserByUserId(params.get("userId"));
        if(authentication==null) {
            header.add("message","없는 계정입니다.");
            return new ResponseEntity<>(header, HttpStatus.NOT_FOUND);
        }
        if (!passwordEncoder.matches(params.get("password"), authentication.getPassword())) {
            header.add("message","잘못된 비밀번호입니다.");
            return new ResponseEntity<>(header, HttpStatus.BAD_REQUEST);
        }
        header.add("message", "good");
        String token=jwtTokenProvider.createToken(authentication.getUserUuid(), authentication.getAuthorities());
        header.add("X-AUTH-TOKEN",token);
        body.put("profileId",authentication.getUserProfile().getProfileId().toString());

        return new ResponseEntity<>(body,header,HttpStatus.OK);
    }

    @PostMapping("/forgot/id")
    public ResponseEntity<?> forgotId(@RequestBody Map<String,String> params){
        MultiValueMap<String, String> header = new LinkedMultiValueMap<>();
        Map<String, String> body = new HashMap<>();
        String maskingEmail=authService.findUserNameByNameAndPhone(params.get("name"),params.get("phone"));
        if(maskingEmail==null) {
            header.add("message","해당 정보의 계정이 없습니다.");
            return new ResponseEntity<>(header, HttpStatus.BAD_REQUEST);
        }
        header.add("message", "good");
        body.put("profileId",maskingEmail);
        return new ResponseEntity<>(body,header,HttpStatus.OK);
    }

    @PostMapping("/forgot/password")
    public ResponseEntity<?> forgotPassword(@RequestBody Map<String,String> params){
        MultiValueMap<String, String> header = new LinkedMultiValueMap<>();
        Map<String, String> body = new HashMap<>();
        String userId=params.get("userId");
        if(userId==null) {
            header.add("message","해당 정보의 계정이 없습니다.");
            return new ResponseEntity<>(header, HttpStatus.BAD_REQUEST);
        }
        header.add("message", "good");
        return new ResponseEntity<>(body,header,HttpStatus.OK);
    }


}
