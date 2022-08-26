package com.thaiitwork;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;


@SpringBootApplication
@EnableRetry
public class ThaiitworkApplication {
	public static void main(String[] args) {
		SpringApplication.run(ThaiitworkApplication.class, args);
	}
}
