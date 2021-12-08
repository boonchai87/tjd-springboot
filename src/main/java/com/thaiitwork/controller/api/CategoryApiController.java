package com.thaiitwork.controller.api;

import com.thaiitwork.exception.ResourceNotFoundException;
import com.thaiitwork.model.Category;
import com.thaiitwork.model.Topic;
import com.thaiitwork.model.User;
import com.thaiitwork.repository.CategoryRepository;
import com.thaiitwork.repository.TopicRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.dozer.util.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RequestMapping("/api/category")
public class CategoryApiController {
    @Autowired
    private CategoryRepository repository;

    @Autowired
    private TopicRepository topicRepository;


    @ApiOperation(value = "Create Category ", notes = "Inquiry Customer by ID Card or Passport Number")
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Category create(@Valid @RequestBody Category object) {
        return repository.save(object);
    }

    //@CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("")
    public Iterable<Category> retrive(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Category findOne(@ApiParam(value = "category id", required = true) @PathVariable("id") @Min(1) Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Category.class.getName(),"id",id));
    }

    @PutMapping("/{id}")
    public Category update(@Valid @RequestBody Category obj,@PathVariable("id") Long id) {
        repository.findById(obj.getId()).orElseThrow(() -> new ResourceNotFoundException(Category.class.getName(),"id",obj.getId()));
        return repository.save(obj);
    }

    @DeleteMapping("/{id}")
    void deleteBook(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @GetMapping("/category/view/{id}")
    public Category categoryView(@ApiParam(value = "category id", required = true) @PathVariable("id") Long id, Pageable pageable, Model model) {
        Category cat = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Category.class.getName(),"id",id));
        model.addAttribute("category",cat);
        Page<Topic> topics = topicRepository.findAll(pageable);
        cat.getTopics().addAll(IteratorUtils.toList(topics.iterator()));
        return cat;
    }
}
