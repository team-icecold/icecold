package com.example.icecold.controllers;

import com.example.icecold.repositories.UserRepository;
import org.springframework.stereotype.Controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    private UserRepository usersDao;
    private PasswordEncoder passwordEncoder;

    public UserController(UserRepository usersDao, PasswordEncoder passwordEncoder){
        this.usersDao = usersDao;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "users/login";
    }


    @GetMapping("/dashboard")
    public String showDashboard() {
        return "users/dashboard";
    }
}