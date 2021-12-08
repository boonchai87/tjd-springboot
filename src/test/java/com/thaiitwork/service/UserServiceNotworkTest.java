package com.thaiitwork.service;

import com.thaiitwork.model.User;
import com.thaiitwork.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceNotworkTest {

    @Mock  // not working  https://www.baeldung.com/java-spring-mockito-mock-mockbean
    private UserRepository mockUserRepository;

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
        Mockito.when(mockUserRepository.findAll()).thenReturn(users);

        // then
        List allUsers = userService.getAllUsers();
        assertThat(allUsers.size()).isEqualTo(1);
    }
}