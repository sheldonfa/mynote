package com.demo.mapper;

import com.demo.pojo.User;

/**
 * Created by Administrator on 2016/7/30.
 */
public interface UserMapper {

    User findUserById(Integer id);
}
