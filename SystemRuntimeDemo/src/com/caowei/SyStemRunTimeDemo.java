package com.caowei;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class SyStemRunTimeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("输出1");
		System.err.println("输出2");
		int[] num1 = {1,2,3,4,5,6,7};
		int[] num2 = new int[num1.length];
		//数组复制:参数（源数组，源数组起始位置，目标数组，目标数组起始位置，目标数组长度）
		System.arraycopy(num1, 0, num2, 0, num1.length);
		System.out.println(Arrays.toString(num2));
		//返回当前计算机时间
		System.out.println(System.currentTimeMillis());
		Date nowDate = new Date(System.currentTimeMillis());
		DateFormat df = new SimpleDateFormat("HH:mm:ss");
		String now = df.format(nowDate);
		System.out.println(now);
		//退出虚拟机:0代表正常退出，非0代表异常退出，使用该
		//方法可以在图像界面编程中实现程序的退出功能等/
//		System.exit(0);
		
		//获取属性
		//java版本
		System.out.println(System.getProperty("java.version"));
		//java安装目录
		System.out.println(System.getProperty("java.home"));
		//操作系统名称
		System.out.println(System.getProperty("os.name"));
		//操作系统的版本
		System.out.println(System.getProperty("os.version"));
		//用户的账户名称
		System.out.println(System.getProperty("user.name"));
		//用户的主目录
		System.out.println(System.getProperty("user.home"));
		//用户的当前工作目录
		System.out.println(System.getProperty("user.dir"));
		
		Runtime rt = Runtime.getRuntime();
		//处理器数量
		System.out.println("处理器数量："+rt.availableProcessors());
		//JVM总内存数单位byte
		System.out.println("JVM总内存数："+rt.totalMemory());
		//JVM空闲内存数
		System.out.println("JVM空闲内存数："+rt.freeMemory());
		//JVM可用最大的内存数
		System.out.println("JVM可用最大的内存数："+rt.maxMemory());
		//单独的进程执行字符串命令
		try {
			rt.exec("notepad");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
