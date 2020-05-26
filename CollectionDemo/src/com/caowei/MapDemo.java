package com.caowei;

import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

/**
 * Map接口：
 *1、键值对存储一组对象
 *2、Key不能重复（唯一），Value可以重复
 *3、具体的实现类：HashMap  TreeMap  Hashtable  LinkedHashMap
 *4、HashMap与HashTable的区别
 *5、如何选择使用哪个？
 */
public class MapDemo {
	/**
	 * 基于二叉树的红黑树实现
	 */
	private static void treeMap() {
//		Map<String,String> map = new TreeMap<>();
//		map.put("one", "lily");
//		map.put("two","Tom");
//		map.put("three","Bin");
//		map.forEach((key,value)->System.out.println(key+"->"+value));
		Map<Dog,String> dogs = new TreeMap<>();
		dogs.put(new Dog(1,"zha",3),"dog1");
		dogs.put(new Dog(1,"wangwang",2), "dog2"); //比较的id所有不能添加
		dogs.put(new Dog(3,"hsq",4), "dog3");
		dogs.forEach((key,value)->System.out.println(key+"->"+value));
		//Dog [id=1, name=zha, age=3]->dog2
		//Dog [id=3, name=hsq, age=4]->dog3
	}
	/**
	 * LinkedHashMap是HashMap的子类，由于HashMap不能保证顺序恒久不变，此类使用一个双重链表来维护
	 * 对象添加元素的顺序
	 */
	private static void linkedHashMap() {
		Map<String,String> table = new LinkedHashMap<>();
		table.put("one", "lily");
		table.put("two","Tom");
		table.put("three","Bin");
		table.forEach((key,value)->System.out.println(key+value));
	}
	/**
	 * JDK1.0开始
	 * 基于哈希表实现（数组+链表）
	 * 默认数组大小为11，加载因子是0.75
	 * 扩充方式：原数组大小<<1（*2）+1
	 * 线程安全的，用在多线程访问
	 */
	private static void hashtable() {
		Map<String, String> table = new Hashtable<>();
		table.put("one", "lily");
		table.put("two","Tom");
		table.put("three","Bin");
		table.forEach((key,value)->System.out.println(key+value));
	}
	/**
	 * HashMap的实现原理：
	 * 1、基于哈希表（数组+链表+二叉树（红黑树））
	 * 2、默认加载因子0.75，数组初始大小16
	 * 3、把对象存储到哈希表中，如何存储？
	 * 把key对象通过hash()方法计算hash值，然后用这个hash值和对数组长度取余数（16）
	 *来决定该key对象在数组中存储的位置，当这个位置有多个对象时，以链表结构存储，
	 *JDK1.8后，当链表长度大于8时，链表将转换为红黑树结构。
	 *这样的目的时为了更快的取值，存储的数据量越大，性能表现越明显
	 * 4、扩充原理：当数组容量超过了75%，那么表示该数组需要扩充，如何扩充？
	 * 扩充算法：当前数组容量<<1（相当与乘2），扩大一倍，扩充次数过多会影响性能（需要
	 * 重新计算每个值的位置），尽量减少数组扩充
	 * 5、线程不安全，适合在单线程使用
	 */
	private static void hashMap() {
		Map<Integer,String> map = new HashMap<>();
		map.put(1, "tom");
		map.put(2, "jack");
		map.put(3, "Vince");
		map.put(4, "Bin");
		map.put(5, "Lisy");
		System.out.println("size:"+map.size());
		//map取值
		System.out.println(map.get(1));
		
		//map遍历
		//1遍历键值
		Set<Entry<Integer,String>> entrySet = map.entrySet();
		for(Entry e:entrySet) {
			System.out.println(e.getKey()+"->"+e.getValue());
		}
		//2遍历键（可以拿到值）
		Set<Integer> keys = map.keySet();
		for(Integer i:keys) {
			String value = map.get(i);
			System.out.println(i+"->"+value);
		}
		//3只能遍历值（拿不到键）
		Collection<String> values = map.values();
		for(String value:values) {
			System.out.println(value);
		}
		//foreach
		map.forEach((key,value)->System.out.println(key+"->"+value));
	}
	public static void main(String[] args) {
//		hashMap();
//		hashtable();
//		linkedHashMap();
		treeMap();
	}

}
