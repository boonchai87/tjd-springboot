package com.thaiitwork.controller;

import com.thaiitwork.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/webboard")
public class WebboardController {
    @Autowired
    private TopicRepository topicRepository;

    @GetMapping("/")
    public String index(){
        // list category
        return "webboard/index";
    }

    @GetMapping("/topic")
    public String topic(){
        // upload file
        return "webboard/topic";
    }

    @PostMapping("/answer")
    public String answer(){
        // upload file
        return "webboard/topic";
    }
}
