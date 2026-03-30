package com.project.legaldocumentanalyzer.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class LoginController {

    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> data) {

        String username = data.get("username");
        String password = data.get("password");

        if(username.equals("admin") && password.equals("admin")) {
            return "success";
        } else {
            return "fail";
        }
    }
}