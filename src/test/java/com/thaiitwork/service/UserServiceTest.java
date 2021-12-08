package com.thaiitwork.service;

import com.thaiitwork.model.User;
import com.thaiitwork.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
public class UserServiceTest {
    @TestConfiguration
    static class UserServiceTestImplTestContextConfiguration {
        @Bean
        public UserService userService() {
            return new UserService() {
                // implement methods
            };
        }
    }

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Before
    public void setUp() {

    }

    @Test
    public void whenValidName_thenEmployeeShouldBeFound() {
        // given
        User alex = User.builder()
                .id(1l)
                .build();
        List<User> users = new ArrayList<User>();
        users.add(alex);

        // when
        Mockito.when(userRepository.findAll()).thenReturn(users);

        // then
        List allUsers = userService.getAllUsers();
        assertThat(allUsers.size()).isEqualTo(1);
    }
}