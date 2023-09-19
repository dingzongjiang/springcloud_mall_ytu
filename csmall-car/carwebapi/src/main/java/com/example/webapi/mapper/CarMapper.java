package com.example.webapi.mapper;

import com.example.mall.commons.dto.CarDto;
import com.example.mall.commons.entity.Car;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

@Mapper
public interface CarMapper {

    @Select("SELECT t_cart.cid, t_cart.num, t_cart.pid, t_cart.uid, t_product.title, t_cart.price FROM t_cart JOIN t_product ON t_cart.pid = t_product.id WHERE t_cart.uid = #{uid}")
    ArrayList<CarDto> getCars(Integer uid);

    @Delete("DELETE from t_cart where cid = #{id}")
    Boolean deleteCar(Integer id);

    @Insert("insert into t_cart(uid,pid,price,num) values(#{uid},#{pid},#{price},1)")
    Boolean createCar(Car car);

    @Update("update t_cart set num = #{num} where cid = #{cid}")
    Boolean updateCar(CarDto carDto);

    @Select("SELECT * from t_cart where uid = #{uid} and pid = #{pid}")
    Boolean checkCart(Car car);
}
