package com.caowei;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;

/**
 * 
 * 字节字符转换流
 * OutputStreamWriter:可以将输出的字符转换为子节流的输出形式
 * InputStreamReader:将输入的字节流转换为字符流入形式
 *
 */

public class ChangeStreamDemo {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
//		InputStream in = new FileInputStream("c:\\test\\t.txt");
//		read(in);
		OutputStream out = new FileOutputStream("c:\\test\\t.txt");
		write(out);
	}
	private static void write(OutputStream out) {
		Writer writer = new OutputStreamWriter(out,Charset.defaultCharset());
		try {
			writer.write("开开心心");
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static void read(InputStream in) {
		Reader reader = new InputStreamReader(in);
		char[] cs = new char[1024];
		int len = -1;
		try {
			while((len = reader.read(cs)) != -1) {
				System.out.println(new String(cs,0,len));
			}
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
