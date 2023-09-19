package com.example.mallorderwebapi.mapper;

import com.example.mall.commons.entity.Order;
import org.apache.ibatis.annotations.*;


import java.util.List;

@Mapper
public interface OrderMapper {
    @Select("select * from orders where user_id = #{uid}")
    List<Order> selectAll(Integer uid);

    @Update("update orders set state = #{state},pay_time = #{pay_time},alipay_no=#{alipay_no} where order_id = #{order_id};")
    int updateState(@Param("order_id") String tradeNo, @Param("state") String state, @Param("pay_time")
    String gmtPayment, @Param("alipay_no") String alipayTradeNo);

    @Delete("DELETE FROM orders WHERE id = #{id}")
    int deleteOrderById(String id);

    @Insert("INSERT INTO orders(product_name, order_id, user_id, price,quantity,order_date) " +
            "VALUES(#{productName}, #{orderId}, #{userId}, #{price}, #{quantity}, #{orderDate})")
    boolean addOrder(Order order);
}
