package com.example.webapi.service;


import com.example.mall.commons.dto.CarDto;
import com.example.mall.commons.entity.Car;
import com.example.service.ICarService;
import com.example.webapi.mapper.CarMapper;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

@DubboService
@Service
public class CarServiceImpl implements ICarService {

    @Resource
    private CarMapper carMapper;

    @Override
    public ArrayList<CarDto> getCars(Integer uid) {
        return carMapper.getCars(uid);
    }

    @Override
    public Boolean deleteCar(Integer id) {
        return carMapper.deleteCar(id);
    }

    @Override
    public Boolean createCar(Car car) {
        Boolean result = carMapper.checkCart(car);
        if(result == null){
            return carMapper.createCar(car);
        }else {
            return false;
        }
    }

    @Override
    public Boolean updateCar(CarDto carDto) {
        return carMapper.updateCar(carDto);
    }


}
