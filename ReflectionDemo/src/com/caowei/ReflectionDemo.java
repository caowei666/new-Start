package com.caowei;

import org.junit.Test;

import java.lang.reflect.*;

public class ReflectionDemo {
    @Test
    public void test5(){
        Dog dog = new Dog("wangwang",5,"black");
        Class<Dog> dogClass = Dog.class;
        Package aPackage = dogClass.getPackage();
        System.out.println(aPackage.getName());
        //获取公告的方法，包括继承的公有方法
        Method[] methods = dogClass.getMethods();
        for (int i = 0; i < methods.length; i++) {
            System.out.println(methods[i]);
            if(methods[i].getName().equals("toString")){
//                Object invoke = methods[i].invoke(dog);
                try {
                    String s = (String)methods[i].invoke(dog);
                    System.out.println(s);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("------");
        //访问私有方法,获取到本类中定义的所有方法（不包括父类）
        Method[] declaredMethods = dogClass.getDeclaredMethods();
        for (int i = 0; i < declaredMethods.length; i++) {
            System.out.println(declaredMethods[i]);
            if(declaredMethods[i].getName().equals("set")){
                //设置私有方法可以被访问
                declaredMethods[i].setAccessible(true);
                try {
                    declaredMethods[i].invoke(dog);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Test
    public void test4(){
        Class<Dog> dogClass = Dog.class;
        //获取非私有的属性
        Field[] fields = dogClass.getFields();
//        System.out.println(fields.length);
        //获取所有属性，包括私有属性
        Field[] declaredFields = dogClass.getDeclaredFields();
//        System.out.println(declaredFields.length);
        for (int i = 0; i < declaredFields.length; i++) {
            int modifiers = declaredFields[i].getModifiers();
            System.out.println(Modifier.toString(modifiers)+" "+declaredFields[i].getType()+" "+declaredFields[i].getName());

        }
    }
//    public class java.lang.String type
//    private class java.lang.String name
//    private int age
//    private class java.lang.String color
    @Test
    public void test3(){
        Class<Dog> dogClass = Dog.class;
        //获取所有的构造方法
        Constructor<?>[] constructors = dogClass.getConstructors();
        for (int i = 0; i < constructors.length; i++) {
            System.out.println(constructors[i].getName());
            System.out.println(constructors[i].getParameterCount());
        }
        try {
            //获取一个指定的构造方法
            Constructor<Dog> constructor = dogClass.getConstructor(String.class, int.class, String.class);
            //调用带参数的构造器来实例化对象
            Dog dog = constructor.newInstance("小白", 5, "白色");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    /**
     * 通过反射实例化对象
     */
    public void test2(){
        Class<Dog> dogClass = Dog.class;
        try {
            //通过Class对象实例化类对象，调用了默认无参的构造方法
            Dog dog = (Dog) dogClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    /**
     * 获取Class对象的三种方式
     */
    @Test
    public void test1(){
        //通过对象的getClass()方法
        Dog dog = new Dog("wangwang",2,"白色");
        Class aClass = dog.getClass();

        //通过类.class
        Class dogClass = Dog.class;

        //通过Class.forName方法
        try {
            Class aClass1 = Class.forName("com.caowei.Dog");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
