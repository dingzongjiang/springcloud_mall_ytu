package com.example.mall.address.webapi.mapper.controller;


import com.example.mall.address.service.AddressService;
import com.example.mall.address.service.request.AddressRequest;
import com.example.mall.commons.entity.Address;


import com.example.mall.user.entity.User;
import com.example.mall.user.webapi.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


@RestController
@CrossOrigin(origins = "*",maxAge = 3600)   //允许跨域访问
public class AddressController {
    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }


    @PostMapping("/address/add")
    public ResponseEntity<Map<String,Object>> addAddress(@RequestBody AddressRequest addressRequest) {

        int result=addressService.addAddress(
                addressRequest.getCodedata(),
                addressRequest.getFormdata(),
                addressRequest.getNamedata(),
                addressRequest.getUsertoken());

        Map<String, Object> response = new HashMap<>();
        if (result == 1) {
            response.put("success", true);
            response.put("message", "恭喜您！新增地址成功！");
            return ResponseEntity.ok().body(response);
        } else {
            response.put("success", false);
            response.put("message", "增加失败");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("/address")
    public ArrayList<Address> getAddress() { User user = TokenUtils.getUser();
        return addressService.getAllAdresss(user.getUid());}

    @GetMapping("/address/default")
    public Address getDefaultAddress() { User user = TokenUtils.getUser();
        return addressService.getdefaultdaddress(user.getUid());}

    @DeleteMapping("/address/{aid}")
    public ResponseEntity<Void> deleteUser(@PathVariable int aid) {
        addressService.deleteAddressByAid(aid);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/address/default/{aid}")
    public ResponseEntity<Void> setDefaultAddress(@PathVariable int aid) {
        User user = TokenUtils.getUser();
        addressService.setDefaultAddress(user.getUid(), aid);
        return ResponseEntity.noContent().build();
    }

}