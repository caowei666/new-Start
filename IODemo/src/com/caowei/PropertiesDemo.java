package com.caowei;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

/**
 * Properties:Properties可以用来做配置文件
 * Javaweb javaee开发中经常用的配置文件
 * 
 *ResourceBundle只读的
 *Properties可读可写
 */

public class PropertiesDemo {

	//静态代码块，只会执行一次
	public static String version = "";
	public static String username = "";
	public static String password = "";
	static{
//		readConfig();
	}
	public static void writeConfig(String version,String username,String password) {
		Properties p = new Properties();
		p.put("app.version",version);
		p.put("db.username",username);
		p.put("db.password",password);
		OutputStream out;
		try {
			out = new FileOutputStream("config.properties");
			//写文件
			p.store(out, "update congig");
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void readConfig() {
		Properties p = new Properties();
		InputStream inStream = null;
		try {
			inStream = new FileInputStream("config.properties");
			p.load(inStream);
			//从properties中获取数据
			PropertiesDemo.version = p.getProperty("app.version");
			PropertiesDemo.username = p.getProperty("db.username");
			PropertiesDemo.password = p.getProperty("db.password");
			inStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		writeConfig("2","caowei","213");
		readConfig();
		System.out.println(PropertiesDemo.version);
		System.out.println(PropertiesDemo.username);
		System.out.println(PropertiesDemo.password);
	}
}
