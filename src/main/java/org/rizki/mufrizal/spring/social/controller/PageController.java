package org.rizki.mufrizal.spring.social.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 01 April 2018
 * @Time 6:20 PM
 * @Project Spring-Social
 * @Package org.rizki.mufrizal.spring.social.controller
 * @File PageController
 */
@Controller
public class PageController {

    @GetMapping(value = "/")
    public String main() {
        return "forward:/index";
    }

    @GetMapping(value = "/index")
    public String index() {
        return "index";
    }

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }

}
