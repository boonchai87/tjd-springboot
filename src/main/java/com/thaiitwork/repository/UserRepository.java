package com.thaiitwork.repository;

import com.thaiitwork.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User,Long> {
    User findByEmail(String email);

    //List<User> findAll();

   /*
   // native query
   @Query(
            value =
                    "insert into Users (name, age, email, status) values (:name, :age, :email, :status)",
            nativeQuery = true)
    void insertUser(@Param("name") String name, @Param("age") Integer age,
                    @Param("status") Integer status, @Param("email") String email);*/

    // jpql
    /*@Query("update User u set u.status = :status where u.name = :name")
    int updateUserSetStatusForName(@Param("status") Integer status,
                                   @Param("name") String name);*/
}
