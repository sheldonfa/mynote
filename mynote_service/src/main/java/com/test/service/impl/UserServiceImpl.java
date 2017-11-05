package com.test.service.impl;


import com.facade.UserService;
import com.test.mapper.UserMapper;
import com.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/7/31.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    public UserMapper userMapper;

}
