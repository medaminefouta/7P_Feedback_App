package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class FeedbackAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(FeedbackAppApplication.class, args);
    }
}
