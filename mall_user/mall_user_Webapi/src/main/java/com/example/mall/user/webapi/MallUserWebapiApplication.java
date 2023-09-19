package com.example.mall.user.webapi;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.mall.user.webapi.mapper")
@EnableDubbo
public class MallUserWebapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallUserWebapiApplication.class, args);
    }

}
