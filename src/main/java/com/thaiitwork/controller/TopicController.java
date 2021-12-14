package com.thaiitwork.controller;

import com.thaiitwork.exception.ResourceNotFoundException;
import com.thaiitwork.model.Topic;
import com.thaiitwork.model.User;
import com.thaiitwork.repository.TopicRepository;
import com.thaiitwork.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin/topic")
public class TopicController {
    @Autowired
    private TopicRepository repository;

    @Autowired
    private UserService userService;

    @GetMapping("")//@GetMapping("/")
    public String retrive(Model model) {
        model.addAttribute("objs", repository.findAll());
        return "topic/retrive";
    }
    @GetMapping("/show/{id}")
    public String show(@PathVariable("id") long id,Model model) {
        Topic topic = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Topic.class.getName(),"id",id));
        model.addAttribute("topic", topic);
        return "topic/show";
    }

    @GetMapping("/create")
    public String showCreateForm(Topic user) {
        return "user/create";
    }

    @PostMapping("/create")
    public String create(@Valid Topic topic, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "topic/create";
        }
        repository.save(topic);
        return "redirect:";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Topic topic = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Topic.class.getName(),"id",id));

        model.addAttribute("topic", topic);
        return "admin/user/edit";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") long id, @Valid Topic obj, BindingResult result, Model model) {
        if (result.hasErrors()) {
            obj.setId(id);
            return "admin/user/update";
        }

        repository.save(obj);
        //model.addAttribute("users", repository.findAll());
        return "redirect:/user";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") long id, Model model) {
        Topic topic = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(User.class.getName(),"id",id));
        repository.delete(topic);
        return "redirect:/topic";
    }

}
