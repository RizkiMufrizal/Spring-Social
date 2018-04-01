package org.rizki.mufrizal.spring.social.service;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.SignInAdapter;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Collections;

/**
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 01 April 2018
 * @Time 6:05 PM
 * @Project Spring-Social
 * @Package org.rizki.mufrizal.spring.social.service
 * @File FacebookSignInAdapter
 */
@Service
public class FacebookSignInAdapter implements SignInAdapter {
    @Override
    public String signIn(String userId, Connection<?> connection, NativeWebRequest request) {
        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(connection.getDisplayName(), null, Collections.singletonList(new SimpleGrantedAuthority("FACEBOOK_USER"))));
        return null;
    }
}
