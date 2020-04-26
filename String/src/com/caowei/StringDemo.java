package com.caowei;

public class StringDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String的两种赋值方式
		//1直接复制
		String s1 = "愤愤";
		//2使用new关键字:该方式会创建两个对象，一个会放在常量池中一个在堆中
		
		String s2 = new String("愤愤");
		
		String s3 = "愤愤";
		System.out.println(s1==s3);
		
		//代码示例：4种情况分析：直接赋值	字符串连接时，考虑编译期和运行期
		//如果在编译期可以被确定，那么就使用已有的对象，否则会创建新对象
		String a = "a";
		String a1 = a+1;
		String a2 = "a1";
		System.out.println(a1 == a2); //false
		
		final String b = "b";	//放在常量池中，编译期可以确定
		String b1 = b+"1";
		String b2 = "b1";
		System.out.println(b1==b2);//true
		
		String c= getString();  //方法在运行期才能确定值
		String c1 = c+1;
		String c2 = "c1";
		System.out.println(c1==c2);//false
		
		final String d = getStringd();//方法在运行期才能确定值
		String d1 = d+1;
		String d2 = "d1";
		System.out.println(d1==d2);//false
	}
	
	private static String getString() {
		return "c";
	}
	private static String getStringd() {
		return "d";
	}

}
