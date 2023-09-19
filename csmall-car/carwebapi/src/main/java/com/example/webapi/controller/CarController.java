package com.example.webapi.controller;

import com.example.mall.commons.dto.CarDto;
import com.example.mall.commons.entity.Car;
import com.example.mall.user.entity.User;
import com.example.mall.user.service.UserService;
import com.example.service.ICarService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;

@RestController
@RequestMapping("/car")
@CrossOrigin(origins = "*",maxAge = 3600)   //允许跨域访问
public class CarController {

    @Resource
    private ICarService carService;

    @DubboReference
    private UserService userservice;
    @GetMapping("/getCars")
    public ArrayList<CarDto> getCars() {
        User user=userservice.getuser();
        return carService.getCars(user.getUid());
    }

    @DeleteMapping("/{cid}")
    public Boolean deleteCar(@PathVariable Integer cid) {
        return carService.deleteCar(cid);
    }

    @DeleteMapping("/deleteCars")
    public void deleteCars(@RequestBody ArrayList<CarDto> carDtos) {
        for (CarDto carDto: carDtos) {
            carService.deleteCar(carDto.getCid());
        }
    }

    @PostMapping("/createCar")
    public Boolean createCar(@RequestBody Car car){
        User user=userservice.getuser();
       car.setUid(user.getUid());
       return carService.createCar(car);
    }

    @PutMapping("/update")
    public Boolean updateCar(@RequestBody CarDto carDto){
        return carService.updateCar(carDto);
    }


}
