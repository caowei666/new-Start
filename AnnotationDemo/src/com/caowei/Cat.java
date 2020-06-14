package com.caowei;

import java.util.Arrays;

@MyAnnotation(name="nini",like = {"金鱼","鲫鱼","鲤鱼"},color = Color.GREEN)
public class Cat {
    private String name;
    private int age;
    private Color color;
    private String[] like;

    public String[] getLike() {
        return like;
    }

    public void setLike(String[] like) {
        this.like = like;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Cat() {
    }

    //用于验证方法是否覆盖父类中的方法
    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color=" + color +
                ", like=" + Arrays.toString(like) +
                '}';
    }

    //表示该方法过时了，不建议使用
    @Deprecated
    public String printInfo(){
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
