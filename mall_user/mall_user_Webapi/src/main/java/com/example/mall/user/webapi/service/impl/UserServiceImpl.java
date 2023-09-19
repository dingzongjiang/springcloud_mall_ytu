package com.example.mall.user.webapi.service.impl;

import com.example.mall.user.entity.User;
import com.example.mall.user.service.UserService;
import com.example.mall.user.webapi.mapper.UserMapper;
import com.example.mall.user.webapi.utils.TokenUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@DubboService
public class UserServiceImpl  implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public boolean addUser(User user) {
        return false;
    }

    public int deleteUserById(int uid) {
        return userMapper.deleteUserById(uid);
    }

    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    public User getUserById(int uid) {
        return userMapper.getUserById(uid);
    }

    public PageInfo<User> getAllUsers(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> userList=userMapper.getAllUsers();
        return new PageInfo<>(userList);
    }

    public User getUserByUsername(String username) {
        return userMapper.getUserByUsername(username);
    }

    @Override
    public User getuser()
    {
        return TokenUtils.getUser();
    }


}

