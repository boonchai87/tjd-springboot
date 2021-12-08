package com.thaiitwork.repository;

import com.thaiitwork.model.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends PagingAndSortingRepository<Category,Long> {
    @Query("select c from Category c left join fetch c.topics where c.id=:id ")
    public Category findById2(@Param("id") Long id);
}
