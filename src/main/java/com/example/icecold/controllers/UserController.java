package com.example.icecold.controllers;

import com.example.icecold.repositories.UserRepository;
import org.springframework.stereotype.Controller;

import org.springframework.security.crypto.password.PasswordEncoder;

@Controller
public class UserController {

    private UserRepository usersDao;
    private PasswordEncoder passwordEncoder;


    public UserController(UserRepository usersDao, PasswordEncoder passwordEncoder){
        this.usersDao = usersDao;
        this.passwordEncoder = passwordEncoder;
    }
}