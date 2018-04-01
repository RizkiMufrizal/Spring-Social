package org.rizki.mufrizal.spring.social.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.rizki.mufrizal.spring.social.domain.User;
import org.rizki.mufrizal.spring.social.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.stereotype.Service;

/**
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 01 April 2018
 * @Time 6:07 PM
 * @Project Spring-Social
 * @Package org.rizki.mufrizal.spring.social.service
 * @File FacebookConnectionSignup
 */
@Service
public class FacebookConnectionSignup implements ConnectionSignUp {

    @Autowired
    private UserRepository userRepository;

    @Override
    public String execute(Connection<?> connection) {
        final User user = new User();
        user.setUsername(connection.getDisplayName());
        user.setPassword(RandomStringUtils.randomAlphabetic(8));
        userRepository.save(user);
        return user.getUsername();
    }

}
