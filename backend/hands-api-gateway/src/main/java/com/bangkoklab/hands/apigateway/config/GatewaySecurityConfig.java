package com.bangkoklab.hands.apigateway.config;

import com.bangkoklab.hands.apigateway.utils.jwt.JwtTokenAuthenticationFilter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletResponse;

/**
* @packageName com.bangkoklab.hands.apigateway.config
* @fileName GatewaySecurityConfig
* @author parkjaehyun
* @description
 * api-gateway의 web security configuration 설정
 * 1. JwtTokenAuthenticationFilter 을 이용해 필터링
 * 2. 이후 기존 Spring Security 인증,인가 로직에 따라 사용자 권한에 따른 접근 제어 수행
**/
@EnableWebSecurity
public class GatewaySecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf().disable()
                .logout().disable()
                .formLogin().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .anonymous()
                .and()
                .exceptionHandling().authenticationEntryPoint(
                (req, rsp, e) -> rsp.sendError(HttpServletResponse.SC_UNAUTHORIZED))
                .and()
                .addFilterAfter(new JwtTokenAuthenticationFilter(),
                        UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers("/auth/**").permitAll()
                .antMatchers("/member/**").hasRole("USER")
                .antMatchers("/admin/**").hasRole("ADMIN");
    }
}
