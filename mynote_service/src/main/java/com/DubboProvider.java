package com; /**
 * Created by Administrator on 2016/10/10.
 */

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DubboProvider {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        context.start();

        System.in.read(); // 按任意键退出
    }
}