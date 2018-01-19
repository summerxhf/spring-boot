package com.hf.service;

import com.hf.mapper.UserMapper;
import com.hf.model.User;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {
    @Autowired
    private UserMapper userMapper;
    public User getUserInfo() {
        return userMapper.findUserInfo();
    }
}
