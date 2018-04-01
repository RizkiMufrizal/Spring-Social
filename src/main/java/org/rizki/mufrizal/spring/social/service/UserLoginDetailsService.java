package org.rizki.mufrizal.spring.social.service;

import org.rizki.mufrizal.spring.social.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

/**
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 01 April 2018
 * @Time 6:01 PM
 * @Project Spring-Social
 * @Package org.rizki.mufrizal.spring.social.service
 * @File UserLoginDetailsService
 */
@Service
public class UserLoginDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        org.rizki.mufrizal.spring.social.domain.User user = userRepository.findOne(username);
        if(user == null){
            throw new UsernameNotFoundException("username not found " + username);
        }
        return new User(user.getUsername(), user.getPassword(), true, true, true, true, Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));
    }
}
