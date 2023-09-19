package com.example.mall.user.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class User implements Serializable {
    private Integer uid;
    private String username;
    private String password;
    private String phone;
    private String email;
    private Integer gender;//'性别:0-女，1-男',
    String createdTime;
    public User() {
        this.createdTime = String.valueOf(LocalDateTime.now());
    }
//    private String avatar;

    private String token;

}