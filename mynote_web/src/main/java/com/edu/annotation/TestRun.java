package com.edu.annotation;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2016/11/2.
 */
public class TestRun {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        // 获取被注解类的字节码文件
        Class clazz = TestDemo.class;
        // 获取所有公共方法
        Method[] methods = clazz.getMethods();
        // 遍历方法
        for(Method m: methods){
            boolean isExist = m.isAnnotationPresent(MyTest.class);
            if(isExist){
                m.invoke(clazz.newInstance(),null);
            }
        }
    }
}

