package com.bangkoklab.hands.authservice.controller;

import com.bangkoklab.hands.authservice.common.JwtTokenProvider;
import com.bangkoklab.hands.authservice.data.entity.Authentication;
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

    @PostMapping("/join")
    public ResponseEntity<?> join(@RequestBody Map<String, String> param) {
        Authentication auth=new Authentication();
        MultiValueMap<String, String> header = new LinkedMultiValueMap<>();
        Authentication userDetails=authService.findByUserId(param.get("userId"));
        if(userDetails!=null){
            header.add("message","이미 존재하는 계정입니다.");
            return new ResponseEntity<>(header, HttpStatus.BAD_REQUEST);
        }
        auth.setUserId(param.get("userId"));
        auth.setPassword(passwordEncoder.encode(param.get("password")));
        auth.setUserUuid(UUID.randomUUID().toString().replace("-",""));
        auth.addAuthorities("ROLE_USER");
        if(null!=authService.join(auth)){
            header.add("message","회원가입성공");
            return new ResponseEntity<>(header, HttpStatus.OK);
        }
        header.add("message","잘못된 요청");
        return new ResponseEntity<>(header, HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String,String> params){
        MultiValueMap<String, String> header = new LinkedMultiValueMap<>();
        Authentication authentication = authService.findByUserId(params.get("userId"));
        if(authentication==null) {
            header.add("message","없는 계정입니다.");
            return new ResponseEntity<>(header, HttpStatus.NOT_FOUND);
        }
        if (!passwordEncoder.matches(params.get("password"), authentication.getPassword())) {
            header.add("message","잘못된 비밀번호입니다.");
            return new ResponseEntity<>(header, HttpStatus.BAD_REQUEST);
        }
        header.add("message", "good");
        String token=jwtTokenProvider.createToken(authentication.getUsername(), authentication.getAuthorities());
        header.add("X-AUTH-TOKEN",token);
        return new ResponseEntity<>(header, HttpStatus.OK);
    }

}
