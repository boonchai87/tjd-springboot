package com.thaiitwork.controller.api;

import com.thaiitwork.model.Customer;
//import com.thaiitwork.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/public/customer")
public class CustomerApiController {
//    @Autowired
//    private CustomerRepository repository;

//    @GetMapping("")
//    public List<Customer> getAllCustomer(){
//        return repository.findAll();
//    }

//    @PostMapping("")
//    public Customer create(@Valid @RequestBody Customer customer){
//        return repository.save(customer);
//    }

}
