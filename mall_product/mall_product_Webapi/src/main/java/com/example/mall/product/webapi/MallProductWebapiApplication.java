package com.example.mall.product.webapi;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@MapperScan("com.example.mall.product.webapi.mapper")
@SpringBootApplication
@EnableDiscoveryClient
@EnableDubbo
public class MallProductWebapiApplication {
    public static void main(String[] args) {
        SpringApplication.run(MallProductWebapiApplication.class, args);
    }
}
