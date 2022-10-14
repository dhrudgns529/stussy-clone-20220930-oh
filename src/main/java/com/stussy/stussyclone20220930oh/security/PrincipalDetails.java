package com.stussy.stussyclone20220930oh.security;

import com.stussy.stussyclone20220930oh.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class PrincipalDetails implements UserDetails {

    private User user;

    public PrincipalDetails(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { // 권한 체크
        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(() -> user.getRole().getName());
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() { // 휴먼 계정
        return true;
    }

    @Override
    public boolean isAccountNonLocked() { // 계정 잠금
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() { // 비밀번호 틀림
        return true;
    }

    @Override
    public boolean isEnabled() { // 계정 비활성화
        return true;
    }
}
