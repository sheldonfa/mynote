package com.demo.service.impl;


import com.demo.mapper.UserMapper;
import com.demo.pojo.User;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/7/31.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserMapper userMapper;

    @Override
    public User findUserById(Integer id) {

        User user = userMapper.findUserById(id);
        return user;
    }
}
