package com.example.taskmanagerdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping("/")
    public String homePage() {
        return "home.html";
    }

    @GetMapping("/user")
    public String userPage() {
        return "user.html";
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "admin.html";
    }
}
