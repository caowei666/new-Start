package com.caowei;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;

/**
 * 
 * 字符串流:以一个字符串为数据源，来构造一个字符流
 * 作用：在web开发中，经常在服务器上获取数据，数据的返回格式通常是一个字符串（XML,JSON）
 * 我们需要把这个字符串构造成一个字符流，然后再用一个第三方的数据解析器来解析数据
 * StringWriter:字符串写入流
 */

public class StringStreamDemo {

	public static void main(String[] args) {
		stringReader();
	}
	private static void stringReader() {
		String info = "good good study day dya up";
		StringReader sr = new StringReader(info);
		//流标记器
		StreamTokenizer st = new StreamTokenizer(sr);
		int count = 0;
		while(st.ttype != StreamTokenizer.TT_EOF) {
			try {
				if(st.nextToken() == StreamTokenizer.TT_WORD) {
					count++;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		sr.close();
		System.out.println("count="+count);
	}
}
