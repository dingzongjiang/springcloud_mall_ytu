package com.example.mallorderwebapi.controller;

import cn.hutool.core.date.DateUtil;
import com.example.mall.address.service.AddressService;
import com.example.mall.commons.dto.CarDto;
import com.example.mall.commons.entity.Address;
import com.example.mall.commons.entity.Order;
import com.example.mall.commons.entity.Product;
import com.example.mall.commons.entity.UserBehavior;
import com.example.mall.commons.result.Result;
import com.example.mall.product.service.ProductService;
import com.example.mall.user.entity.User;
import com.example.mall.user.service.UserService;
import com.example.mallorderservice.service.IOrderService;
import com.example.service.ICarService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "*", maxAge = 3600)   //允许跨域访问
public class OrderController {
    @Autowired
    private IOrderService orderService;
    @DubboReference
    private ICarService carService;
    @DubboReference
    private UserService userService;
    @DubboReference
    private ProductService goodsService;
    @DubboReference
    private AddressService addressService;

    @PostMapping("/{id}")
    public Result<?> AddOrder(@PathVariable Integer id){
        //现根据物品的Id去查找物品信息
        Product goods = goodsService.getProduct(id);
        User user = userService.getuser();
        Address defaultaddress=addressService.getdefaultdaddress(user.getUid());
        Order order = new Order();
        order.setOrderId(DateUtil.format(new Date(),"yyyyMMdd")+System.currentTimeMillis());
        order.setProductName(goods.getTitle());
        order.setPrice(goods.getPrice());
        order.setQuantity(goods.getNum());
        order.setOrderDate(new Date());
        order.setUserId(user.getUid());
        System.out.println(order);
        orderService.addOrder(order);
        UserBehavior userBehavior = new UserBehavior();
        userBehavior.setUid(user.getUid());
        int itemid = goods.getId()-10000000;
        userBehavior.setItemid(itemid);
        userBehavior.setRating(1);
        System.out.println(userBehavior);
//        boolean count = userBehaviorMapper.addUserBehavior(userBehavior);
        return Result.success();
    }

//    这个是所有的订单数目
    @GetMapping
    public Result<?> findGoodsByPage() {
        List<Order> orderList =  orderService.selectAll(userService.getuser().getUid());
        return Result.success(orderList);
    }
    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable String id) {
        orderService.DeleteById(id);
        return Result.success();
    }

    @PostMapping("/androidCreate")
    public Result<?> AddOrder(@RequestBody ArrayList<CarDto> carDtos){
        for (CarDto carDto: carDtos) {
//            AddOrder(carDto.getPid());
//            orderService.addOrder(carDto);
            carService.deleteCar(carDto.getCid());
        }
        return Result.success();
    }

}
