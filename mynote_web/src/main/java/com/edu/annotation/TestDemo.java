package com.edu.annotation;

import org.junit.Test;

/**
 * Created by Administrator on 2016/11/2.
 */
public class TestDemo {

    @MyTest
    public void fun1(){
        System.out.println("fun1执行了");
    }

    @MyTest
    public void fun2(){
        System.out.println("fun2执行了");
    }
}
