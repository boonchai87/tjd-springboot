package com.thaiitwork.controller.api;

import com.thaiitwork.exception.ResourceNotFoundException;
import com.thaiitwork.model.Topic;
import com.thaiitwork.repository.TopicRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@RequestMapping("/api/topics")
public class TopicApiController {
    @Autowired
    private TopicRepository repository;


    @ApiOperation(value = "Inquiry Customer", notes = "Inquiry Customer by ID Card or Passport Number")
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Topic create(@Valid @RequestBody Topic object) {
        return repository.save(object);
    }

    //@CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("")
    public Iterable<Topic> retrive(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Topic findOne(@ApiParam(value = "ID Card or Passport Number", required = true) @PathVariable("id") @Min(1) Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Topic.class.getName(),"id",id));
    }

    @PutMapping("/{id}")
    public Topic update(@Valid @RequestBody Topic obj, @PathVariable("id") Long id) {
        repository.findById(obj.getId()).orElseThrow(() -> new ResourceNotFoundException(Topic.class.getName(),"id",obj.getId()));
        return repository.save(obj);
    }

    @DeleteMapping("/{id}")
    void deleteBook(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
