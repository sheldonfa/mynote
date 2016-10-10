package com.controller;

import com.facade.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

/**
 * Created by Administrator on 2016/5/15.
 */

@Controller
public class UserController{

    @Autowired
    private UserService userService;

    @RequestMapping("/queryUser/{id}")
    public String queryUser(@PathVariable Integer id, Model model) throws IOException {
        String hello = userService.findUserById(id);
        System.out.println(hello);
        model.addAttribute("hello",hello);
        return "hello_world";

    }
}

