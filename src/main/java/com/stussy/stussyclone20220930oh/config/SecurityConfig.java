package com.stussy.stussyclone20220930oh.config;

import com.stussy.stussyclone20220930oh.security.AuthFailureHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() { // 복호화
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.httpBasic().disable(); // 기존 로그인 페이지 X
        http.authorizeRequests()
                .antMatchers("/account/mypage","/index", "/checkout") // 지정한 경로로 요청이 들어오면
                .authenticated() // 인증을 거침
//                .antMatchers("/admin/**")
//                .hasRole("ADMIN") // 이 권한을 가지고 있어야함.
                .antMatchers("/admin/**","/api/admin/**")
                .permitAll()
                .anyRequest() // 다른 요청이 들어오면
                .permitAll() // 허용
                //
                .and()
                //
                .formLogin()
                .usernameParameter("email") // 기본 username인 것을 email로 변경
                .loginPage("/account/login") // 로그인 페이지 Get 요청
                .loginProcessingUrl("/account/login") // service Post 요청
                .failureHandler(new AuthFailureHandler())
                .defaultSuccessUrl("/index"); // 로그인 후 이동 할 페이지가 없으면 이 주소로 이동
    }
}
