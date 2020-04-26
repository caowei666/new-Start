package com.caowei;

public class Cat implements Comparable<Cat> {
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Cat [name=" + name + ", age=" + age + "]";
	}
	public Cat() {
		super();
	}
	public Cat(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	//自定义对象实现排序可以实现comparable接口的comparable方法
	@Override
	public int compareTo(Cat o) {
		// TODO Auto-generated method stub
		if(this.age < o.age) {
			return -1;
		}
		if(this.age > o.age) {
			return 1;
		}
		return 0;
	}
}
