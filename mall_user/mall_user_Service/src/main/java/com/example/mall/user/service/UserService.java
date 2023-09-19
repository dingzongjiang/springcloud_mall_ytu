package com.example.mall.user.service;

import com.example.mall.user.entity.User;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public boolean addUser(User user);

    public int deleteUserById(int uid);

    public int updateUser(User user);

    public User getUserById(int uid);

    public PageInfo<User> getAllUsers(int pageNum, int pageSize);

    public User getUserByUsername(String username);
    public User getuser();
}