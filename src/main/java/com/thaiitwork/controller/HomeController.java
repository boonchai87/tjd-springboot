package com.thaiitwork.controller;

import com.thaiitwork.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
    @Autowired
    private TopicRepository topicRepository;

    @GetMapping("/")
    public String index(){

        return "index";
    }


    // Login form
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping("/register")
    public String doRegister(){
        return "";
    }
}
