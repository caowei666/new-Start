package com.caowei;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 * 
 * 字符流：
 * 字符输出流：Writer,对文件的操作使用子类：FileWirter
 * 字符输入流：Reader,对文件的操作使用子类：FileReader
 * 每次操作的单位是一个字符
 * 文件字符操作流会自带缓存，默认大小是1024字节，在缓存满后或手动刷新
 * 或关闭流时会把数据写入文件
 *
 */
public class CharStreamDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		out();
		in();
	}
	private static void in() {
		File file = new File("c:\\test\\t.txt");
		try {
			Reader in = new FileReader(file);
			char[] cs = new char[1];
			int len = -1;
			StringBuilder buf = new StringBuilder();
			while((len = in.read(cs))!=-1) {
				buf.append(new String(cs,0,len));
			}
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
		File file = new File("c:\\test\\t.txt");
		try {
			Writer out = new FileWriter(file,true);
			out.write("小河流水哗啦啦");
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
