package com.thaiitwork.controller.api;

import com.thaiitwork.model.Answer;
import com.thaiitwork.model.Category;
import com.thaiitwork.model.Topic;
import com.thaiitwork.repository.AnswerRepository;
import com.thaiitwork.repository.CategoryRepository;
import com.thaiitwork.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/webboard")
public class WebboardApiController {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @GetMapping("")// don't use @GetMapping("/")
    public Iterable<Category> index(){
        return categoryRepository.findAll();
    }

    @PostMapping("/category")
    public Category createCategory(@Valid @RequestBody Category category){
        return categoryRepository.save(category);
    }

    @GetMapping("/category/{id}")
    public Category categoryView(@PathVariable("id") Long id ){
        return categoryRepository.findById(id).get();
    }

    @GetMapping("/topic/{id}")
    public Topic topicView(@PathVariable("id") Long id ){
       return topicRepository.findById(id).get();
    }

    @PostMapping("/catgory/{id}/create-topic")
    public Topic createTopic(@PathVariable("id") Long id, @Valid @RequestBody Topic topic, BindingResult bindingResult){
        Category category = categoryRepository.findById(id).get();
        topic.setCategory(category);
        return topicRepository.save(topic);
    }

    @PostMapping("/topic/{id}/create-answer")
    public Answer createAnswer(@PathVariable("id") Long id, @Valid @RequestBody Answer answer){
        Topic topic = topicRepository.findById(id).get();
        answer.setTopic(topic);
        return answerRepository.save(answer);
    }
}
