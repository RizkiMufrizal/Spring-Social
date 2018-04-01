package org.rizki.mufrizal.spring.social.controller;

import org.rizki.mufrizal.spring.social.domain.User;
import org.rizki.mufrizal.spring.social.helpers.SocialConnectionHelper;
import org.rizki.mufrizal.spring.social.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

/**
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 01 April 2018
 * @Time 10:11 PM
 * @Project Spring-Social
 * @Package org.rizki.mufrizal.spring.social.controller
 * @File SignUpController
 */
@Controller
public class SignUpController {

    @Autowired
    private ProviderSignInUtils providerSignInUtils;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping(value = "/signup")
    public String formSignUp(Model model, WebRequest webRequest) {
        Connection<?> connection = providerSignInUtils.getConnectionFromSession(webRequest);
        model.addAttribute(SocialConnectionHelper.signUpUser(connection));
        return "signup";
    }

    @PostMapping(value = "/signup")
    public String formSignUpPost(@ModelAttribute("user") User user, WebRequest webRequest) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User userSignUp = userRepository.save(user);
        providerSignInUtils.doPostSignUp(userSignUp.getUsername(), webRequest);
        return "redirect:/";
    }

}