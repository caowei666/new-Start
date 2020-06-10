package com.caowei;

import org.junit.Test;

import java.util.*;

public class GenericDemo {
    @Test
    public void test5(){
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"vince");
        map.put(2,"tom");
        Set<Map.Entry<Integer, String>> entrySet = map.entrySet();
        for(Map.Entry entry:entrySet){
            System.out.println(entry.getKey()+"--"+entry.getValue());
        }
    }
    @Test
    public void test4(){
        String[] arrays = {"vince","jack","tom","lily"};
        String[] func = func(arrays, 0, 1);
        System.out.println(Arrays.toString(func));
    }
    /**
     * 泛型方法
     */
    public static <T> T[] func(T[] array,int i,int t){
        T temp = array[i];
        array[i] = array[t];
        array[t] = temp;
        return array;
    }

    @Test
    public void testNode2(){
        Node<Number> n1 = new Node<>(1.23);
        Node<Integer> n2 = new Node<>();
        getData(n1);
        //getData(n2);  //编译不通过
        //n1 = n2;//编译错误
        getData2(n2);
        getData2(n1);
        getData3(n1);
        getData3(n2);
    }
    public static void getData(Node<Number> node){
        System.out.println(node.getData());
    }
    //使用通配符定义泛型类型，此时只能输出，不能修改
   public static void getData2(Node<?> node){
        //node.setData(20);  //编译报错
        System.out.println(node.getData());
    }
    //上限
    //下线 Node<? super Integer>
    public static void getData3(Node<? extends Number> node){
        //只能是Number和Number子类
        //node.setData(20);  //编译错误
        System.out.println(node.getData());
    }


    @Test
    public void testNode(){
        Node<Number> numberNode = new Node<>();
        Node<Integer> intNode = new Node<>(10);
        Integer data = intNode.getData();
        System.out.println(data);
    }
    @Test
    public void test1(){
        List<String> list = new ArrayList();
        list.add("vince");
        for (int i = 0; i < list.size(); i++) {

        }
    }
}
