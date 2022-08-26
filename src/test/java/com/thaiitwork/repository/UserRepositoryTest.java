package com.thaiitwork.repository;

import com.thaiitwork.model.IdsOnly;
import com.thaiitwork.model.User;
import com.thaiitwork.util.Status;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
class UserRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void myTest() {
        //subject.save(new MyEntity());
        User u = User.builder()
                .email("neng87@gmail.com")
                .userName("dd")
                .password("ddd")
                        .build();
        userRepository.save(u);
        Assert.assertNotNull(u.getId());
    }

    @Test
    public void given_ValidInput_When_GetAllIds_Then_success(){
        User u = User.builder()
                .email("neng87@gmail.com")
                .userName("dd")
                .password("ddd")
                .status(Status.ENABLE)
                .userRole("xxx")
                .created(new Date())
                .updated(new Date())
                .build();
        userRepository.save(u);

        List<IdsOnly> ids = userRepository.getAllOnlyIds();
        Assert.assertEquals(ids.size(),1);
        System.out.println(ids.get(0).getUserName());
        Assert.assertEquals(ids.get(0).getUserName(),"dd");
    }
}