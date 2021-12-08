package com.thaiitwork.controller;

import com.thaiitwork.model.User;
import com.thaiitwork.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/userFlux")
public class EmployeeController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    private Mono<User> getEmployeeById(@PathVariable Long id) {
        return Mono.just(userRepository.findById(id).get());
    }

    @GetMapping
    private Flux<User> getAllEmployees() {
        return Flux.fromIterable(userRepository.findAll());
    }

    @PostMapping("/update")
    private Mono<User> updateEmployee(@RequestBody User employee) {
        return Mono.just(userRepository.save(employee));
    }

}
