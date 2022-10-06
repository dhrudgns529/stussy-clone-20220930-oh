package com.stussy.stussyclone20220930oh.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.httpBasic().disable(); // 기존 로그인 페이지 X
        http.authorizeRequests()
                .antMatchers("/account/mypage","/index") // 지정한 경로로 요청이 들어오면
                .authenticated() // 인증을 거침
                .anyRequest() // 다른 요청이 들어오면
                .permitAll() // 허용
                //
                .and()
                //
                .formLogin()
                .loginPage("/account/login") // 로그인 페이지
                .defaultSuccessUrl("/index"); // 로그인 후 이동 할 페이지가 없으면 이 주소로 이동
    }
}
