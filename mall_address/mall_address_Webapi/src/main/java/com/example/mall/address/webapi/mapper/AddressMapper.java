package com.example.mall.address.webapi.mapper;




import com.example.mall.commons.entity.Address;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface AddressMapper {

    List<Address> getDefaultAddress(@Param("uid") Integer uid);

    @Select("SELECT * FROM t_address WHERE uid = #{uid} AND is_default = 1")
    Address getDefaultAddressByUid(int uid);


    int insertAddress(@Param("address") Address address);

    @Select(" select *\n" +
            "        from t_address\n" +
            "        where uid = #{uid}")
    ArrayList<Address> getAllAdresss(Integer uid);

    @Delete("DELETE FROM t_address WHERE aid = #{aid}")
    int deleteAddressByAid(int aid);


    @Update("UPDATE t_address SET is_default = CASE WHEN aid = #{aid} THEN 1 ELSE 0 END WHERE uid = #{uid}")
    int setDefaultAddress(@Param("uid") int uid, @Param("aid") int aid);
}
