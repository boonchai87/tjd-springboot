package com.thaiitwork.controller;

import java.util.List;

import com.thaiitwork.model.Topic;
import com.thaiitwork.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.models.Model;

@Controller
@RequestMapping("/webboard")
public class WebboardController {
    @Autowired
    private TopicRepository topicRepository;

    @GetMapping("/topic/{id}")
    public String viewTopic(@PathVariable("id") Long id, Pageable pageable,Model model) {
        //topicRepository.findAll(pageable);

        return "webboard/viewTopic";
    }

    @GetMapping("/topic")
    public String addTopic() {
        // upload file

        // insert into db
        return "webboard/addTopic";
    }

    @PostMapping("/topic/{id}/addAnswer")
    public String addAnswer(@PathVariable("id") Long id) {
        // upload file
        // create answer
        // insert into Topic
        return "redirect:/webboard/topic/" + id;
    }
}
