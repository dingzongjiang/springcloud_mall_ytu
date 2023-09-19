package com.example.mall.commons.entity;

import lombok.Data;

@Data
public class Product {
    private Integer id;
    private Integer categoryId;
    private Integer num;
    private String title;
    private String sellPoint;
    private String itemType;
    private Integer price;

    public Product(Integer num, String title, String sellPoint, String itemType, Integer price) {
        this.num = num;
        this.title = title;
        this.sellPoint = sellPoint;
        this.itemType = itemType;
        this.price = price;
    }

    public Product(Integer id, Integer categoryId, Integer num, String title, String sellPoint, String itemType, Integer price) {
        this.id = id;
        this.categoryId = categoryId;
        this.num = num;
        this.title = title;
        this.sellPoint = sellPoint;
        this.itemType = itemType;
        this.price = price;
    }

    public Product() {
    }
}
