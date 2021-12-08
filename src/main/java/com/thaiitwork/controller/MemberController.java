package com.thaiitwork.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {
    public String index(){
        return "member/index";
    }

    @GetMapping("/topics")
    public String listTopic(){
        // get topic
        return "";
    }

    @GetMapping("/answser")
    public String listAnswer(){
        return "";
    }
}
