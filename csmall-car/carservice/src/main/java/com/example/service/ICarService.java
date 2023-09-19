package com.example.service;

import com.example.mall.commons.dto.CarDto;
import com.example.mall.commons.entity.Car;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface ICarService {

    ArrayList<CarDto> getCars(Integer uid);

    Boolean deleteCar(Integer id);


    Boolean createCar(Car car);

    Boolean updateCar(CarDto carDto);
}
