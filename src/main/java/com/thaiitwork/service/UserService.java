package com.thaiitwork.service;

import com.thaiitwork.model.User;
import com.thaiitwork.repository.UserRepository;
import org.dozer.util.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService{
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return IteratorUtils.toList(userRepository.findAll().iterator());
        // users.iterator()
        //return new ArrayList<User>(userRepository.findAll());
        //return IteratorUtils.toList();
    }
}
