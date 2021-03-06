package com.caowei;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 
 *字节输入输出流
 *输出流：超类OutputStream,对文件的输出流使用子类FileOutputStream
 *输入流：超类InputStream,对文件的输入流使用子类FileInputStream
 *输入输出字节流操作原理，每次只会操作一个字节（从文件中读取或者写入）
 *字节操作流默认每次执行写入操作会直接把数据写入到文件
 *
 *如何选择使用字节流还是字符流
 *一般操作非文本（图片、视频等）文件时使用字节流，操作文本文件，建议使用字符流
 *
 *字符流的内部实现还是字节流
 *
 */

public class ByteStreamDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		out();
		in();
	}
	private static void in() {
		//1、确定目标文件
		File file = new File("C:\\test\\t.txt");
		try {
			//2构建一个文件输入流对象
			InputStream in = new FileInputStream(file);
			//数组长度不能为1，因为汉字占两个字节，会读成乱码
			byte[] bytes = new byte[10]; //1024字节
			StringBuilder buf = new StringBuilder();
			int len = -1;//表示每次读取的字节长度
			//把输入读入到数组中，并返回读取的字节数，当不等于-1时表示读取到数据
			//等于-1表示文件已经读完了
			while((len = in.read(bytes)) != -1) {
				//根据读取到的字节数组，再转换为字符串内容，添加到StringBuilder中
				buf.append(new String(bytes,0,len));
			}
			//关闭输入流
			in.close();
			System.out.println(buf);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static void out() {
		//1、确定目标文件
		//2、构建一个文件输出流对象
		File file = new File("C:\\test\\t.txt");
		try {
			//默认是覆盖的写入，加上第二个参数true，表示追加内容
			OutputStream out = new FileOutputStream(file,true);
			//3、输出的内容是,window下换行\r\n
			String info = "小河流水哗啦啦\r\n";
			//获取换行符 == \r\n(windows下)
			//String line = System.getProperty("line.separator");
			//4、把内容写入到文件
			out.write(info.getBytes());
			//5、关闭流
			out.close();
			System.out.println("写完了");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
