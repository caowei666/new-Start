package com.caowei;

public class StringBufferrDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "a";
		String b = "b";
		String c = a+b+1;   //会产生5个对象 编译期有变量
		System.out.println(c);
		
		String d = "a"+1+2+3+4+"b"; //产生一个对象 编译期都是常量
		//常量相加没有性能问题（编译期进行优化）
		//StringBuffer目的时来解决字符串相加时带来的性能问题
		//StringBuffer的内部实现采用字符数组，默认数组长度为16，超过数组大小
		//，动态扩充的算法是str*2+2;
		//当我们预知数据长度时，建议使用带初始化容量的构造方法，来避免动态扩充的次数
		//从而提高效率
		//是线程安全的，会影响性能
		StringBuffer sb = new StringBuffer(100);
		sb.append(a).append(b).append(1);
		System.out.println(sb.toString());
		
	}

}
