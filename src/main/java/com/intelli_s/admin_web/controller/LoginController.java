package com.intelli_s.admin_web.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Log4j2
public class LoginController {

    @GetMapping("/login")
    public void login(String error, String logout, Model model) {

        if(error != null) {
            model.addAttribute("error", "* 아이디와 비밀번호를 다시 확인해주세요 *");
        }
        if(logout != null) {
            model.addAttribute("logout", "로그아웃 완료!");
        }

        return;
    }
}
