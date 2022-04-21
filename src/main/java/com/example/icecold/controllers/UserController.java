package com.example.icecold.controllers;

import com.example.icecold.models.User;
import com.example.icecold.repositories.UserRepository;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.security.crypto.password.PasswordEncoder;

@Controller
public class UserController {

    private UserRepository usersDao;
    private PasswordEncoder passwordEncoder;

    public UserController(UserRepository usersDao, PasswordEncoder passwordEncoder){
        this.usersDao = usersDao;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/register")
    public String showRegistrationForm(){ return "users/register"; }

    @PostMapping("/register")
    public String submitRegistrationForm(
            @RequestParam(name="username") String username,
            @RequestParam(name="email") String email,
            @RequestParam(name="password") String password,
            @RequestParam(name="password-confirm") String passwordconfirm){

            // Redefine into specific errors later, for now all registration errors are in one boolean
        boolean errors = false;
        User newUser = new User(username, email, password);
        if ((usersDao.findByUsername(newUser.getUsername()) != null) || (password != passwordconfirm)){
            errors = true;
            return "redirect:/register";
        } else {
            String hash = passwordEncoder.encode(password);
            newUser.setPassword(hash);
            User created = usersDao.save(newUser);
        }
        return "redirect:/login";
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