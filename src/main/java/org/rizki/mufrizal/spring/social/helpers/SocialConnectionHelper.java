package org.rizki.mufrizal.spring.social.helpers;

import org.rizki.mufrizal.spring.social.domain.User;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.facebook.api.Facebook;

/**
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 01 April 2018
 * @Time 10:16 PM
 * @Project Spring-Social
 * @Package org.rizki.mufrizal.spring.social.helpers
 * @File SocialConnectionHelper
 */
public class SocialConnectionHelper {
    public static User signUpUser(Connection<?> connection) {
        User user = new User();

        if (connection != null) {
            UserProfile userProfile;
            Object api = connection.getApi();
            if (api instanceof Facebook) {
                Facebook facebookApi = (Facebook) api;
                String[] fields = {"id", "name", "birthday", "email", "location", "hometown", "gender", "first_name", "last_name"};
                org.springframework.social.facebook.api.User facebookUser = facebookApi.fetchObject("me", org.springframework.social.facebook.api.User.class, fields);
                userProfile = new UserProfile(facebookUser.getId(), facebookUser.getName(), facebookUser.getFirstName(), facebookUser.getLastName(), facebookUser.getEmail(), facebookUser.getMiddleName());
            } else {
                userProfile = connection.fetchUserProfile();
            }
            user.setUsername(userProfile.getEmail());
        }
        return user;
    }
}
