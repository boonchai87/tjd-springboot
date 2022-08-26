package com.thaiitwork.service;

import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public interface MyService {
    @Retryable(value = RuntimeException.class)// Here, the retry is attempted when a RuntimeException is thrown.
    void retryService(String sql);

}