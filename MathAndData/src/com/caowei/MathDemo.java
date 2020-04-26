package com.caowei;
import static java.lang.Math.floor; //静态导入

import java.util.Random;
public class MathDemo {

	public static void main(String[] args) {
		
		System.out.println(Math.PI);
		System.out.println(Math.abs(-1010));
		System.out.println(Math.random()*100); //0<= r < 1
		System.out.println(Math.round(3.9));  //四舍五入
		System.out.println(Math.round(Math.sqrt(2)*1000)/1000.0);//求平方根并保留三位小数
		//使用静态导入
		System.out.println(floor(1.23455)); //最接近参数的最大整数
		
		Random r = new Random();
		System.out.println(r.nextLong());
		System.out.println(r.nextInt(5));
	}

}
