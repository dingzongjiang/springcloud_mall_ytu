package com.example.mall.address.webapi.service.impl;


import com.auth0.jwt.JWT;

import com.example.mall.address.service.AddressService;
import com.example.mall.address.webapi.mapper.AddressMapper;
import com.example.mall.commons.entity.Address;
import com.example.mall.commons.entity.CodeData;
import com.example.mall.commons.entity.FormData;
import com.example.mall.commons.entity.NameData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressMapper addressMapper;

    @Autowired
    public AddressServiceImpl(AddressMapper addressMapper) {
        this.addressMapper = addressMapper;
    }

    @Override
    public int addAddress(CodeData codedata, FormData formdata, NameData namedata, String userToken) {
        /*Integer areaCode = codedata.getAreaCode();
        Integer cityCode = codedata.getCityCode();
        Integer provinceCode = codedata.getProvinceCode();*/
        String provinceCode = codedata.getProvince().toString();
        String cityCode = codedata.getCity().toString();
        String areaCode = codedata.getArea().toString();
        String address = formdata.getAddress();
        String name = formdata.getName();
        String phone = formdata.getPhone();
        String area = namedata.getArea();
        String city = namedata.getCity();
        String province = namedata.getProvince();
        /**
         * userToken里面还有uid，需要以后解析，现在没有
         */
        Integer uid = Integer.valueOf(JWT.decode(userToken).getAudience().get(0));
        List<Address> AddressList = addressMapper.getDefaultAddress(uid);

//        System.out.println(AddressList);
//        Integer isDefault = AddressList == null ? 1 : 0;
        Integer isDefault=0;
        if (AddressList.isEmpty()) {
            isDefault=1;
        }
        String createTime = LocalDateTime.now().toString();

        Address address1 = new Address(uid, name, province, provinceCode, city, cityCode, area, areaCode, address, phone, isDefault, createTime);
//        System.out.println(address1);
       return addressMapper.insertAddress(address1);


    }

    @Override
    public ArrayList<Address> getAllAdresss(Integer uid) {
        return addressMapper.getAllAdresss(uid);
    }

    @Override
    public int deleteAddressByAid(int aid) {
        return addressMapper.deleteAddressByAid(aid);
    }

    @Override
    public int setDefaultAddress(int uid, int aid) {
//        System.out.println(aid+"分割"+uid);
        return addressMapper.setDefaultAddress(uid,aid);
    }

    @Override
    public Address getdefaultdaddress(int uid) {
        return addressMapper.getDefaultAddressByUid(uid);
    }
}
