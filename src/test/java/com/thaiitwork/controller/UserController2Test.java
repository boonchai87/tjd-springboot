package com.thaiitwork.controller;

import com.thaiitwork.controller.api.UserApiController;
import com.thaiitwork.model.User;
import com.thaiitwork.repository.UserRepository;
import com.thaiitwork.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value= UserApiController.class)
public class UserController2Test {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void getHello() throws Exception {
        // given
        User alex = User.builder()
                .id(1l)
                .build();
        List<User> users = new ArrayList<User>();
        users.add(alex);

        BDDMockito.given(userService.getAllUsers()).willReturn(users);
        Mockito.verify(userService, VerificationModeFactory.times(1)).getAllUsers();
        //Mockito.when(userService.getAllUsers()).thenReturn(users);

        // when  // then
        mvc.perform(get("/api/users").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));

        Mockito.reset(userService);
    }
}