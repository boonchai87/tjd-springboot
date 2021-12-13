package com.thaiitwork.controller.api;

import com.thaiitwork.exception.ResourceNotFoundException;
import com.thaiitwork.model.User;
import com.thaiitwork.repository.UserRepository;
import com.thaiitwork.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserApiController {
    @Autowired
    private UserRepository repository;

    @Autowired
    private UserService userService;

    @ApiOperation(value = "Inquiry Customer", notes = "Inquiry Customer by ID Card or Passport Number")
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@Valid @RequestBody User object) {
        return repository.save(object);
    }

    //@CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("")
    @PreAuthorize("hasAnyRole('ROLE_USER')")
    public Iterable<User> retrive(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public User findOne(@ApiParam(value = "ID Card or Passport Number", required = true) @PathVariable("id") @Min(1) Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(User.class.getName(),"id",id));
    }

    @PutMapping("/{id}")
    public User update(@Valid @RequestBody User obj, @PathVariable("id") Long id) {
        // check obj is existing
        repository.findById(obj.getId()).orElseThrow(() -> new ResourceNotFoundException(User.class.getName(),"id",obj.getId()));
        return repository.save(obj);
    }

    @DeleteMapping("/{id}")
    void deleteBook(@PathVariable Long id) {
        // check obj is existing
        repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(User.class.getName(),"id",id));
        repository.deleteById(id);
    }
}
