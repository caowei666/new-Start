package com.caowei;

import java.text.MessageFormat;
import java.util.Locale;

/**
 * ResourceBundle工具类，绑定属性文件，并指定locale对象
 */
import java.util.ResourceBundle;
import java.util.Scanner;

public class I18NDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//创建一个本地语言环境对象，该对象会根据参数设置来自动选择与之相关的语言环境
		//参数：语言，地区
		Locale locale_CN = new Locale("zh","CN");
		Locale locale_US = new Locale("en","US");
		Locale locale_default = Locale.getDefault();
		
		Scanner input = new Scanner(System.in);
		//用于绑定属性文件的工具类（参数：属性文件的基本名（就是前缀，比如info））
		ResourceBundle r = ResourceBundle.getBundle("com.caowei.info", locale_CN);
		System.out.println(r.getString("system.name"));
		System.out.println(r.getString("input.username"));
		String username = input.nextLine();
		System.out.println(r.getString("input.password"));
		String password = input.nextLine();
		
		if("admin".equals(username) && "123".equals(password)) {
			System.out.println(r.getString("login.success"));
			String welcome = r.getString("welcome");
			welcome = MessageFormat.format(welcome, username);
			System.out.println(welcome);
		}else {
			System.out.println(r.getString("Login.error"));
		} //key写错会报错MissingResourceException
	}

}
