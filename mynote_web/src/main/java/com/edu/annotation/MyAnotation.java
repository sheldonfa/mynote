package com.edu.annotation;

/**
 * Created by Administrator on 2016/11/2.
 */
public @interface MyAnotation {

    // 属性
    int age();

    String name();

    // default属性
    String sex() default "";

    // value属性可以省写
//    String value();

    // value数组
    String[] value();
}
