package com.caowei;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * Collection接口：用于存储单个对象的集合
 *有两个子接口：
 *	1、List接口：有序的、允许多个空元素
 *		具体的常用的实现类：ArrayList、Vector、LinkedList
 *		实际开发中如何选择list的具体实现呢：1、安全性问题，2、是否频繁插入，删除操作（LinkedList）
 *			3、是否存储后遍历（ArrayList）
 *	2、Set接口：
 */

public class ListDemo {
	/**
	 * LinkedList
	 * 1、实现原来：采用双向链表结构实现
	 * 2、适合插入，删除操作，性能高
	 */
	private static void linkedList() {
		LinkedList<String> list = new LinkedList<String>();
		list.add("苍老师");
		list.add("李老师");
		list.add("张老师");
		list.add("毕老师");
		for(int i =0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
	}
	/**
	 * Vector
	 * 1、采用动态对象数组，默认构造方法创建了一个大小为10的对象数组
	 * 2、扩充的算法：当增量为0时，扩充为原来大小的2倍，当增量大于0时，扩充为原来大小+增量
	 * 3、不适合删除或插入操作
	 * 4、为了防止数组动态的扩充次数过多，建议创建vector时，给定初始容量
	 * 5、线程安全，适合在多线程访问时使用，在单线程时效率较低
	 */
	private static void vector() {
		Vector <String> v = new Vector<String>();
		v.add("苍老师");
		v.add("李老师");
		v.add("张老师");
		v.add("毕老师");
		for(int i =0;i<v.size();i++) {
			System.out.println(v.get(i));
		}
	}
	/**
	 * ArrayList
	 * 1、实现原理，采用动态对象数组，默认构造方法创建了一个空数组
	 * 2、第一次添加元素，扩充容量为10，之后的扩充算法：院里数组大小+原来数组的一半
	 * 3、不适合删除或插入操作
	 * 4、为了防止数组动态的扩充次数过多，建议创建ArrayList时，给定初始容量
	 * 5、线程不安全，适合在单线程访问时使用，效率较高
	 */
	private static void arrayList() {
		//使用集合来存储多个不同类型的元素，那么在处理时会比较麻烦，在实际
		//开发中不建议这样使用，我们应该在一个集合里存储相同的类型对象
		List<String> list = new ArrayList<>();
		list.add("苍老师");
		list.add("李老师");
		list.add("张老师");
		list.add("毕老师");
		list.add("10");
		for(int i =0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		System.out.println(list.contains("苍老师"));
		list.remove("毕老师");
		System.out.println(list.size());
		String[] array = list.toArray(new String[] {});
		for(String s:array) {
			System.out.println(s);
		}
	}

	public static void main(String[] args) {
//		arrayList();
//		vector();
		linkedList();
	}

}
