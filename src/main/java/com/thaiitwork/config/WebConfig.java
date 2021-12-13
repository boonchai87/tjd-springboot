package com.thaiitwork.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class WebConfig {
    public static final String USER_ROLE = "ROLE_USER";
    public static final String ADMIN_ROLE = "ROLE_ADMIN";

    @Bean
    public BCryptPasswordEncoder encoder(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }
}
