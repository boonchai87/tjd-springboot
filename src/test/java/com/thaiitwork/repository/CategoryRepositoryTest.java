package com.thaiitwork.repository;

import com.thaiitwork.model.Category;
import static org.assertj.core.api.Assertions.*;

import com.thaiitwork.model.User;
import com.thaiitwork.model.Topic;
import org.assertj.core.util.IterableUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryTest {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private UserRepository userRepository;

    private Category category =null;

    @Before
    @Transactional
    public void setup(){
        // given
        User u = User.builder()
                .name("xxx")
                .email("neng87@gmail.com")
                .build();
        userRepository.save(u);

        category = Category.builder()
                .numTopic(0)
                .title("title")
                .build();
        categoryRepository.save(category);

        Topic topic = Topic.builder()
                .title("xxx")
                .category(category)
                .numAnswer(0)
                .numView(0)
                .content("xxx")
                .user(u)
                .build();
        topicRepository.save(topic);
    }

    @Test
    public void given_ValidData_when_create_then_success(){
        //given
        Category category = Category.builder()
                .numTopic(0)
                .title("title")
                .build();
        // when
        categoryRepository.save(category);
        System.out.println(category);
        //AssertThat(category.getId())

        assertThat(category.getId()).isNotNull();
    }

    @Test
    public void when_call_listAll_then_return_success(){
        // given
        Category category = Category.builder()
                .numTopic(0)
                .title("title")
                .build();
        categoryRepository.save(category);

        //when
        Iterable<Category> categories = categoryRepository.findAll();

        // then
        assertThat(IterableUtil.sizeOf(categories)).isGreaterThan(0);
    }

    @Test
    public void given_Valid_CategoryId_when_GetCategory_then_Return1Topic(){
        /*// given
        User u = User.builder()
                 .name("xxx")
                .email("neng87@gmail.com")
                .build();
        userRepository.save(u);

        Category category = Category.builder()
                .numTopic(0)
                .title("title")
                .build();
        categoryRepository.save(category);

        Topic topic = Topic.builder()
                .title("xxx")
                .category(category)
                .numAnswer(0)
                .numView(0)
                .content("xxx")
                .user(u)
                .build();
        topicRepository.save(topic);*/

        //when
        Category newCat = categoryRepository.findById2(category.getId());


        //then
        assertThat(newCat.getTopics().size()).isEqualTo(1);
    }



}