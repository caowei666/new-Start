package com.caowei;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;

public class EnumDemo {
    public static final int RED = 0x1;
    public static final int GREEN = 0x2;
    public static final int BLUE = 0x3;
    public int color;
    @Test
    public void test1(){
        color = RED;
    }

    public Color colorEnum;
    @Test
    public void test2(){
        colorEnum = Color.RED;
        colorEnum = Color.GREEN;
        System.out.println(colorEnum);
        System.out.println(colorEnum.name());
        System.out.println(colorEnum.ordinal());
        System.out.println(colorEnum.toString());
        Color[] values = Color.values();
        System.out.println(Arrays.toString(values));
    }

    @Test
    public void test3(){
        //创建一个EnumSet,里面包含Color的所有对象
        EnumSet<Color> set = EnumSet.allOf(Color.class);
        for (Color c:set){
            System.out.println(c);
        }

        EnumMap<Color,String> map = new EnumMap<Color, String>(Color.class);
        map.put(Color.RED,"red");
        map.put(Color.GREEN,"green");
        map.put(Color.BLUE,"blue");
        for(Map.Entry<Color,String> entry:map.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }
    @Test
    public void test4(){
        System.out.println(Color.RED);  //使用枚举类型就调用所有构造方法
        //调用有参构造方法
        //调用无参构造方法
        //调用无参构造方法
        //RED
        System.out.println(Color.RED.getColor()); //10
        System.out.println(Color.RED.getColor2());  //red
    }

    //使用枚举实现单例设计模式
    @Test
    public void test5(){
        Singleton.SINGLETON.method();
    }
}
