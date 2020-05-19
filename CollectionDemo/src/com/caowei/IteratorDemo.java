package com.caowei;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.function.Function;

public class IteratorDemo {
	/**
	 * Function接口的使用
	 */
	private static void functionTest() {
		String s = strToUpp("caowei",(str)->str.toUpperCase());
		System.out.println(s);
	}
	public static String strToUpp(String str,Function<String,String> f) {
		return f.apply(str);
	}
	/**
	 * JDK1.8新的迭代方法
	 * Consumer接口的使用
	 */
	private static void foreachTest() {
		List<String> lists = new ArrayList<>();
		lists.add("tom");
		lists.add("jack");
		lists.add("lisi");
		//Consumer接口 forEach接口中传Consumer接口
//		lists.forEach((String s)->System.out.println(s));
		lists.forEach(System.out::println);
	}
	private static void enumration() {
		Vector<String> vs = new Vector<String>();
		vs.add("tom");
		vs.add("jack");
		vs.add("job");
		vs.add("lisa");
		Enumeration<String> es = vs.elements();
		while(es.hasMoreElements()) {
			System.out.println(es.nextElement());
		}
	}
	//foreach 1.5后才有
	private static void iterator1(Collection<Cat> c) {
		for(Cat cat:c) {
			System.out.println(cat);
		}
	}
	//1.5之前统一的迭代集合方式
	private static void iterator2(Collection<Cat> c) {
		Iterator<Cat> iter = c.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
	public static void main(String[] args) {
		List<Cat> list = new ArrayList<Cat>();
		Cat c1 = new Cat("miaomiaomiao",5,1);
		Cat c2 = new Cat("huahua",2,2);
		Cat c3 = new Cat("tom",5,3);
		Cat c4 = new Cat("miaomiaomiao",3,1);
		list.add(c1);
		list.add(c2);
		list.add(c3);
		list.add(c4);
//		iterator2(list);
//		iterator1(list);
//		enumration();
//		foreachTest();
		functionTest();
	}

}
