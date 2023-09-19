package com.example.mallorderwebapi;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.mallorderwebapi.mapper")
@EnableDubbo
public class MallOrderWebapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallOrderWebapiApplication.class, args);
    }

}
