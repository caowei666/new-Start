package com.caowei;

import java.lang.annotation.*;

/**
 * 自定义注解
 * 给我们提供了一种设置并读取配置文件的方法
 */
//表示用于生成文档
@Documented    //注解的注解
//表示该注解作用范围在运行时存在
@Retention(RetentionPolicy.RUNTIME)   //注解的注解
//注解可以使用在什么位置(类型，方法，属性，构造器，参数，局部变量，包，注解上)
@Target(ElementType.TYPE)   //注解的注解
//子类是否可以继承父类的注解（加上了就可以使用）
@Inherited   //注解的注解
public @interface MyAnnotation {
    //定义变量
    public String name();
    public int age() default 2;  //给变量设置默认值
    //定义数组变量
    public String[] like();
    //定义枚举
    public Color color();
}
