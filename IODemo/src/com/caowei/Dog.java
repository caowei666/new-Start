package com.caowei;

import java.io.Serializable;
//如果一个类创建的对象需要被序列化，那么该类必须实现Serializable接口
//Serializable是一个标记接口，没有任何定义，为了告诉JVM该对象可以被序列化

//什么时候对象需要被序列化呢？
//1、把对象保存到文件中（存储到物理介质）
//2、对象需要在网络上传输时

//如果对象没有实现Serializable会包异常//java.io.NotSerializableException
public class Dog implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name;
	private String sex;
	private int age;
	private transient int id; // 在序列化中被忽略的属性（还原时会变为0）；
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Dog(String name, String sex, int age) {
		super();
		this.name = name;
		this.sex = sex;
		this.age = age;
	}
	public Dog() {
		super();
	}
	@Override
	public String toString() {
		return "Dog [name=" + name + ", sex=" + sex + ", age=" + age + "]";
	}
	
}
