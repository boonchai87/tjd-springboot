package com.thaiitwork.repository;

import com.thaiitwork.model.Answer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends PagingAndSortingRepository<Answer,Long> {

}
