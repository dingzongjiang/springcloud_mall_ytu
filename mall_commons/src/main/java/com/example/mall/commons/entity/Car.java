package com.example.mall.commons.entity;

import lombok.Data;

@Data
public class Car {
    private Integer cid;
    private Integer num;
    private Integer pid;
    private Integer uid;
    private Integer price;

    public Car() {
    }

    public Car(Integer cid, Integer num, Integer pid, Integer uid) {
        this.cid = cid;
        this.num = num;
        this.pid = pid;
        this.uid = uid;
    }
}
