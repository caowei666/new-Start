package com.caowei.ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JDK7Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//jdk1.5之后
		//Scanner input = new Scanner(System.in);
		
		
		//br.close();
		
		//1.7新特性
		//自动关闭流
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			System.out.println("请输入数字");
			String info = br.readLine();
			int num = Integer.parseInt(info);
			System.out.println(num);
		} catch(IOException|NumberFormatException e) {
			e.printStackTrace();
		}
	}

}
