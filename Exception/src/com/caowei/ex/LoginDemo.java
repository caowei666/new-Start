package com.caowei.ex;

/**
 * Exception和RuntimeException
 * Exception:受检异常，在编译期检查，在调用抛出这个异常的方法时，必须显示的使用try{}catch(){}
 * RuntimeException:非受检异常，在运行期检查，在调用抛出这个异常的方法时，不用显示的使用try{}catch(){}
 * 在使用自定义异常时，根据业务要求，来决定使用哪个作为继承的父类
 */
import java.util.Scanner;

public class LoginDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("请输入用户名");
		String name = input.nextLine();
		System.out.println("请输入密码");
		String pass = input.nextLine();
		UserSerivce us = new UserSerivce();
		try {
			User user = us.login(name, pass);
			System.out.println("登录成功");
			System.out.println(user.toString());
		} catch (MyException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println(e);
		}
	}

}
