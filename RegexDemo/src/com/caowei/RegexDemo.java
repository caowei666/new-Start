package com.caowei;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {
    @Test
    public void test(){
        String phoneNumber = "010-38389438";
        boolean b = phoneNumber.matches("\\d{3,4}-\\d{7,8}");
        System.out.println(b);

        String phone = "13343533950";
        System.out.println(phone.matches("[1][3-9]\\d{9}"));
        //匹配用户名：字母开头，数字字母下划线组合
        String userName = "abc1314";
        System.out.println(userName.matches("[a-zA-Z]+[\\w|_]*"));

        //匹配ip
        String ip = "20.10.10.123";
        System.out.println(ip.matches("\\d{1,3}.\\d{1,3}.\\d{1,3}.\\d{1,3}"));

        //匹配网址
        String addr = "http://www.baidu.com";
        System.out.println(addr.matches("http://\\w+.\\w+.\\S*"));

        //匹配年龄
        String age = "18";
        System.out.println(age.matches("\\d{1,3}"));

        //匹配金额
        String price = "19.8";
        System.out.println(price.matches("\\d+.\\d+"));
    }
    @Test
    public void test3(){
        String s = "5201314";
        boolean b = s.matches("[0-9]+");
        boolean b1 = s.matches("\\d+");
        System.out.println(b+"--"+b1);
    }
    @Test
    public void test2(){
        Pattern p = Pattern.compile("a*b");
        Matcher matcher = p.matcher("aaab");
        boolean b = matcher.matches();
        System.out.println(b);
    }
    @Test
    public void test1(){
        String s = "12345";
        char[] chars = s.toCharArray();
        boolean flag = true;
        for (int i = 0; i < chars.length; i++) {
            if(chars[i]<'0' || chars[i]>'9'){
                flag = false;
                break;
            }
        }
        if(flag){
            System.out.println("是数组组成");
        }else {
            System.out.println("不是数字组成");
        }
    }
}
