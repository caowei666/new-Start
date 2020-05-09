package com.caowei;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
/**
 * 字节数组流：在内存中处理字符串
 * 基于内存操作，内部维护者一个字节 数组，我们可以利用流的读取机制来处理字符串
 * 不需要关闭
 */

public class ByteArrayStreamDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byteArray();
	}
	private static void byteArray() {
		String s = "123fagrreg$#!@%$&^&GSSGTH";
		ByteArrayInputStream bais = new ByteArrayInputStream(s.getBytes());
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		int curr = -1; //每次读取的字节
		while((curr=bais.read())!=-1) {
			if((curr>=65 && curr <= 90) || (curr>=97 &&curr <=122)) {
				baos.write(curr);
			}
		}
		//此时无需关闭，原因时字节数组流是基于内存的操作流
		System.out.println(baos.toString());
		System.out.println(baos.toString().length());
	}
}
