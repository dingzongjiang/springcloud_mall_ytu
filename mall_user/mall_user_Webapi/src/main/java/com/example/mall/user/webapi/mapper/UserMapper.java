package com.example.mall.user.webapi.mapper;

import com.example.mall.user.entity.User;
import org.apache.ibatis.annotations.*;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

@Mapper
public interface UserMapper {
    @Insert("INSERT INTO t_user(username, password, phone, email, gender, created_time) VALUES(#{username}, #{password}, #{phone}, #{email}, #{gender}, #{createdTime})")
    boolean addUser(User user);

    @Delete("DELETE FROM t_user WHERE uid = #{uid}")
    int deleteUserById(int uid);

    @Update("UPDATE t_user SET username = #{username}, password = #{password}, phone = #{phone}, email = #{email}, gender = #{gender}, created_time = #{createdTime} WHERE uid = #{uid}")
    int updateUser(User user);

    @Select("SELECT * FROM t_user WHERE uid = #{uid}")
    User getUserById(int uid);

    @Select("SELECT * FROM t_user")
    List<User> getAllUsers();

    @Select("SELECT * FROM t_user WHERE username = #{username}")
    User getUserByUsername(@Param("username") String username);

    @Select("SELECT * FROM t_user WHERE uid = #{uid}")
    User selectById(int uid);
}