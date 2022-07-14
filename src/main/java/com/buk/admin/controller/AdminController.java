package com.buk.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.buk.user.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AdminController {
    private final UserService userService;
    
    @GetMapping("/admin")
    public String admin() {
        return "admin/admin";
    }

    @GetMapping("/login")
    public String loginPage() {
        userService.getPasswordEncode();
        return "/admin/login";
    }
}
