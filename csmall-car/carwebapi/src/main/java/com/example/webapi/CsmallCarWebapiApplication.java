package com.example.webapi;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class CsmallCarWebapiApplication {
    public static void main(String[] args) {
        SpringApplication.run(CsmallCarWebapiApplication.class, args);
    }
}
