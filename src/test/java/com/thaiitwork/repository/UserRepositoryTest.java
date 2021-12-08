package com.thaiitwork.repository;

import com.thaiitwork.model.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
class UserRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void myTest() throws Exception {
        //subject.save(new MyEntity());
        User u = User.builder()
                .email("neng87@gmail.com")
                .name("dd")
                .password("ddd")
                        .build();
        userRepository.save(u);
        Assert.assertNotNull(u.getId());
    }
}