package com.caowei;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class FileDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//File类表示一个文件或目录
		//C:\\test\\t.txt 或 C:/test/t.txt
		File f1 = new File("C:\\test\\t1.txt");
		if(!f1.exists()) {
			try {
				f1.createNewFile();
				System.out.println("文件创建成功");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//f1.isFile()
		System.out.println("是否为文件夹"+f1.isDirectory());
		f1.delete();
		
		File f2 = new File("c:\\test\\my");
		if(!f1.exists()) {
			try {
				f2.createNewFile();
				System.out.println("文件夹创建成功");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
//		String[] names = f2.list();
		System.out.println(Arrays.toString(f2.list()));
		boolean b = f2.delete();   //存在文件的文件夹不能删除
		System.out.println(b);
		
		File[] fs = f2.listFiles(); //列出当前目录下的所有文件，以file对象返回
		for(File f:fs) {
			System.out.println("length"+f.length());
			System.out.println("name"+f.getName());
			System.out.println("相对路径"+f.getPath());
			System.out.println("绝对路径"+f.getAbsolutePath());
			System.out.println("是否为隐藏文件"+f.isHidden());
			System.out.println("是否可读文件"+f.canRead());
			Date date = new Date(f.lastModified());
			DateFormat df = new SimpleDateFormat("HH:mm:ss");
			System.out.println("文件最后修改的时间"+df.format(date));
		}
		File f3 = new File("temp.txt");
		System.out.println(f3.getAbsolutePath());
		System.out.println(f3.getPath());
		
		//创建文件夹
		File f4 = new File("c:\\test\\dabin1");
		f4.mkdir();
		//重命名与移动文件
//		f4.renameTo(new File("c:\\\\test\\\\dabin1"));
		f4.renameTo(new File("c:\\dabin1"));
		
		File f5 = new File("c:\\test\\my");
//		File[] files1 = f5.listFiles(new FileFilter() {
//
//			@Override
//			public boolean accept(File pathname) {
//				// TODO Auto-generated method stub
//				return pathname.getName().endsWith(".txt");
//			}
//			
//		});
		File[] files1 = f5.listFiles((pathname)->pathname.getName().endsWith(".txt"));
		for(File f:files1) {
			System.out.println(f.getName());
		}
		System.out.println("------------");
	}

}
