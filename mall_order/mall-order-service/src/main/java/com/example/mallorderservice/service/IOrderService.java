package com.example.mallorderservice.service;

import com.example.mall.commons.entity.Order;

import java.util.List;

public interface IOrderService {
    List<Order> selectAll(Integer uid);

    int DeleteById(String id);

    boolean addOrder(Order order);
}
