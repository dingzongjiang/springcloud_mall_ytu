package com.example.mall.address.webapi;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@MapperScan("com.example.mall.address.webapi.mapper")
@SpringBootApplication
@EnableDiscoveryClient
@EnableDubbo
public class MallAddressWebapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallAddressWebapiApplication.class, args);
    }

}
