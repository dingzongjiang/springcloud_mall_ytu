package com.example.mall.address.service;




import com.example.mall.commons.entity.Address;
import com.example.mall.commons.entity.CodeData;
import com.example.mall.commons.entity.FormData;
import com.example.mall.commons.entity.NameData;

import java.util.ArrayList;

public interface AddressService {
    int addAddress(CodeData codedata, FormData formdata, NameData namedata, String userToken);

    ArrayList<Address> getAllAdresss(Integer uid);

    public int deleteAddressByAid(int uid);

    int setDefaultAddress(int uid,int aid);

    Address getdefaultdaddress(int uid);
}
