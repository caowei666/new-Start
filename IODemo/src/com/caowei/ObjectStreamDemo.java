package com.caowei;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class ObjectStreamDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		writeObject();
		readObject();
	}
	
	private static void readObject() {
		File file = new File("c:\\test\\dog.obj");
		InputStream in = null;
		ObjectInputStream ois = null;
		try {
			in = new FileInputStream(file);
			ois = new ObjectInputStream(in);
			Dog dog = (Dog)ois.readObject();
			ois.close();
			System.out.println(dog);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//java.io.NotSerializableException
	
	//对象序列化：把对象写入文件；实际写入的是类名、属性名、属性类型、属性值等
	private static void writeObject() {
		Dog dog = new Dog("wangwang","母",3);
		File file = new File("c:\\test\\dog.obj");
		OutputStream out = null;
		ObjectOutputStream oos = null;
		try {
			out = new FileOutputStream(file);
			oos = new ObjectOutputStream(out);
			oos.writeObject(dog);
			oos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
