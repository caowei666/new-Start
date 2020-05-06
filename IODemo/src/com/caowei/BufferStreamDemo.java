package com.caowei;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

/**
 * 
 * 缓存的目的：
 * 解决在写入文件操作时，频繁的操作文件所带来的性能下降
 * BufferedOutputStream 内部默认的缓存大小是8kB，每次写入时存储的缓存的byte数组中，
 * 当数组缓存满时，会把数据写入文件，并且缓存下标归零
 *
 *
 *字符流：
 *1、加入字符缓冲流，增强读取功能（readLine方法)
 *2、更高效的读取数据
 */

public class BufferStreamDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		byteWriter();
//		byteReader();
		charReader();
//		charWriter();
	}
	private static void charWriter() {
		File file = new File("c:\\test\\t.txt");
		try {
			Writer writer = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(writer);
			bw.write("789");
			bw.flush();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static void charReader() {
		File file = new File("c:\\test\\t.txt");
		try {
			Reader reader = new FileReader(file);
			BufferedReader br = new BufferedReader(reader);
			char[] cs = new char[1024];
			int len = -1;
			while((len = br.read())!=-1) {
				System.out.println(new String(cs,0,len));
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static void byteReader() {
		File file = new File("c:\\test\\t.txt");
		try {
			InputStream in = new FileInputStream(file);
			//构造一个字节缓冲流
			BufferedInputStream bis = new BufferedInputStream(in);
			byte[] bytes = new byte[1024];
			int len = -1;
			while((len = bis.read(bytes)) != -1) {
				System.out.println(new String(bytes,0,len));
			}
			bis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static void byteWriter() {
		File file = new File("c:\\test\\t.txt");
		try {
			OutputStream out = new FileOutputStream(file);
			BufferedOutputStream bos = new BufferedOutputStream(out);
			String info = "哗啦啦啦";
			bos.write(info.getBytes());
			bos.close(); //自动关闭out不用手动关
//			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
