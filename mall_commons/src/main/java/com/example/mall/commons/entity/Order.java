package com.example.mall.commons.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Order {
    private Integer id;
    private String orderId;//订单编号
    private Integer userId;
    private String productName;
    private Integer quantity;//商品数量
    private Integer price;
    private Integer total;
    private String  state;
    private String  payTime;//商品支付时间
    private String  alipayNo;//支付宝流水号
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    Date orderDate;//订单创建时间
}
