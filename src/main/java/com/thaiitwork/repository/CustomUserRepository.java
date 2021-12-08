package com.thaiitwork.repository;

import com.thaiitwork.model.User;

import java.util.List;
import java.util.Set;

public interface CustomUserRepository {
    List<User> findUserByEmails(Set<String> emails);
}
