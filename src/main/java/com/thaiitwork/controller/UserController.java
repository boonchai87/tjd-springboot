package com.thaiitwork.controller;

import com.thaiitwork.exception.ResourceNotFoundException;
import com.thaiitwork.model.User;
import com.thaiitwork.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository repository;

    @GetMapping("")//@GetMapping("/")
    public String retrive(Model model) {
        model.addAttribute("users", repository.findAll());
        return "user/retrive";
    }
    @GetMapping("/show/{id}")//@GetMapping("/")
    public String show(@PathVariable("id") long id,Model model) {
        User user = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(User.class.getName(),"id",id));
        model.addAttribute("user", user);
        return "user/show";
    }

    @GetMapping("/create")
    public String showCreateForm(User user) {
        return "user/create";
    }

    @PostMapping("/create")
    public String create(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "user/create";
        }
        repository.save(user);
        //model.addAttribute("users", repository.findAll());
        return "redirect:";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        User user = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(User.class.getName(),"id",id));

        model.addAttribute("user", user);
        return "user/edit";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") long id, @Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            user.setId(id);
            return "user/update";
        }

        repository.save(user);
        //model.addAttribute("users", repository.findAll());
        return "redirect:/user";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") long id, Model model) {
        User user = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(User.class.getName(),"id",id));
        repository.delete(user);
        //model.addAttribute("users", repository.findAll());
        return "redirect:/user";
    }


}
