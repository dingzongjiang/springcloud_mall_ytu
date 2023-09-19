package com.example.mallorderwebapi.service.Impl;

import com.example.mall.commons.entity.Order;

import com.example.mallorderservice.service.IOrderService;
import com.example.mallorderwebapi.mapper.OrderMapper;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@DubboService
public class IOrderServiceImpl implements IOrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<Order> selectAll(Integer uid) {
        return orderMapper.selectAll(uid);
    }

    @Override
    public int DeleteById(String id) {
        int num = orderMapper.deleteOrderById(id);
        return num;
    }

    @Override
    public boolean addOrder(Order order) {
        return orderMapper.addOrder(order);
    }
}
