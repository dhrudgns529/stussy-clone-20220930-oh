package com.stussy.stussyclone20220930oh.controller;

import com.stussy.stussyclone20220930oh.dto.RegisterReqDto;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AccountController {

    @GetMapping("/account/login")
    public String login(Model model, @RequestParam @Nullable String email) { // Nullable 필수가 아니다.
        model.addAttribute("email", email == null ? "" : email);
        return "account/login";
    }

    @GetMapping("/account/register")
    public String register() {
        return "account/register";
    }
}
