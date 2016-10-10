package com.service;


import com.facade.UserService;
import com.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/7/31.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    public UserMapper userMapper;

    @Override
    public String findUserById(Integer id) {
        return "hello world";
    }
}
