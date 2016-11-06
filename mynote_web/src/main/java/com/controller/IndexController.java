package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2016/11/6.
 */
@Controller
@RequestMapping("/index")
public class IndexController {

    @RequestMapping("/")
    public String index(){
        return "/index_v1";
    }
}
