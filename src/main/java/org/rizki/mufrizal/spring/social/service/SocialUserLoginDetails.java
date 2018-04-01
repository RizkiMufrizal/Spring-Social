package org.rizki.mufrizal.spring.social.service;

import lombok.Getter;
import lombok.Setter;
import org.rizki.mufrizal.spring.social.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.social.security.SocialUserDetails;

import java.util.Collection;
import java.util.HashSet;

/**
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 01 April 2018
 * @Time 9:42 PM
 * @Project Spring-Social
 * @Package org.rizki.mufrizal.spring.social.service
 * @File SocialUserLoginDetails
 */

public class SocialUserLoginDetails implements SocialUserDetails {

    SocialUserLoginDetails(User user) {
        this.user = user;
    }

    @Getter
    @Setter
    private User user;

    @Override
    public String getUserId() {
        return this.user.getUsername();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> grantedAuthorities = new HashSet<>(1);
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_FACEBOOK"));
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
