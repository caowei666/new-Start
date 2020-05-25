package com.caowei;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Map接口：
 *1、键值对存储一组对象
 *2、Key不能重复（唯一），Value可以重复
 *3、具体的实现类：HashMap  TreeMap  Hashtable  LinkedHashMap
 *4、JDK1.8开始当链表长度超过8时把链表变为二叉树
 *把key对象通过hash()方法计算hash值，然后用这个hash值和对数组长度取余数（16）
 *来决定该key对象在数组中存储的位置，当这个位置有多个对象时，以链表结构存储，
 *JDK1.8后，当链表长度大于8时，链表将转换为红黑树结构。
 *这样的目的时为了更快的取值，存储的数据量越大，性能表现越明显
 */
public class MapDemo {
	/**
	 * HashMap的实现原理：
	 * 1、基于哈希表（数组+链表+二叉树（红黑树））
	 * 2、默认加载因子0.75，数组初始大小16
	 * 3、把对象存储到哈希表中
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
		hashMap();
	}

}
