package com.thaiitwork.controller;

import com.thaiitwork.model.User;
import com.thaiitwork.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller("/admin")
public class AdminController {
    @Autowired
    private UserRepository userRepository;

    public String index(){
        return "admin/index";
    }
    @GetMapping("/User")
    public List<User> getMembers(){
        return (List<User>)userRepository.findAll();
    }
}
