package com.caowei;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * 
 * Set接口：
 * 1、无序的
 * 2、不允许重复元素
 * 实现类：HashSet、TreeSet、LinkedHashSet
 *如果要排序选择TreeSet,如果不用排序也不用保证顺序选择HashSet
 *不要排序，要保证顺序选择LinkedHashSet
 */

public class SetDemo {
	/**
	 * 有序的hashSet,按照添加的顺序迭代
	 */
	private static void linkedHashSet() {
		LinkedHashSet<Cat> set = new LinkedHashSet<Cat>();
		Cat c1 = new Cat("miaomiaomiao",5,1);
		Cat c2 = new Cat("huahua",2,2);
		Cat c3 = new Cat("tom",5,3);
		Cat c4 = new Cat("miaomiaomiao",3,1);
		set.add(c1);
		set.add(c2);
		set.add(c3);
		set.add(c4);
		for(Cat c:set) {
			System.out.println(c);
		}
	}
	/**
	 * 有序的，基于TreeMap(二叉树数据结构)，对象需要比较大小，通过对象比较器来实现
	 * 对象比较器还可以去除重复元素，如果我们自定义的数据类没有实现比较器接口，将无法添加到
	 * treeSet集合中
	 */
	private static void treeSet() {
		TreeSet<Cat> tree = new TreeSet<Cat>(new CatComparator());
		Cat c1 = new Cat("miaomiaomiao",5,1);
		Cat c2 = new Cat("huahua",2,2);
		Cat c3 = new Cat("tom",5,3);
		Cat c4 = new Cat("miaomiaomiao",3,1);
		tree.add(c1);
		tree.add(c2);
		tree.add(c3);
		tree.add(c4);
		System.out.println(tree.size());
		for(Cat c: tree) {
			System.out.println(c);
		}
	}
	/**
	 * HashSet
	 * 1、实现原来，基于哈希表（HashMap）实现
	 * 2、不允许重复，可以有一个null元素
	 * 3、不保证顺序恒久不变
	 * 4、添加元素时把元素作为HashMap的key存储，HashMap的value使用一个
	 * 固定的object对象
	 * 5、排除重复元素时通过equals来检查对象是否为同一个元素
	 * 6、判断两个对象是否相同，先判断两个对象的hashCode是否相同（
	 * 如果两个的hashCode相同，不一定是同一个对象，如果不同，一定不是同一个对象）
	 * 如果相同还要进行equals判断，equals相同则是同一个对象，不同则不是同一个对象
	 * 7、自定义对象要认为属性值都相同时为同一个对象，需要重写hashCode方法和equals方法
	 * 
	 * 小结：
	 * （1）哈希表的存储结构：数组+链表，数组里的每个元素以链表的形式存储
	 * （2）如何把对象存储到哈希表中：先计算hashCode值，再对数组的长度求余数，来决定对象
	 * 要存储在数组中的位置
	 */
	private static void hashSet() {
		Set<String> set = new HashSet<String>();
		set.add("飞飞");
		set.add("贝贝");
		set.add("凉凉");
		set.add("关关");
		set.add("凉凉");
		
		String[] names = set.toArray(new String[] {});
		for(String s:names) {
			System.out.println(s);
		}
		Cat c1 = new Cat("miaomiaomiao",5,1);
		Cat c2 = new Cat("huahua",2,2);
		Cat c3 = new Cat("tom",5,3);
		Cat c4 = new Cat("miaomiaomiao",5,1);
		Set<Cat> cats = new HashSet<Cat>();
		cats.add(c1);
		cats.add(c2);
		cats.add(c3);
		cats.add(c4);
		for(Cat c:cats) {
			System.out.println(c);
		}
		System.out.println(cats.size());
		System.out.println("c1="+c1.hashCode());
		System.out.println("c2="+c2.hashCode());
		System.out.println("c3="+c3.hashCode());
		System.out.println("c4="+c4.hashCode());
	}
	public static void main(String[] args) {
//		hashSet();
//		treeSet();
		linkedHashSet();
	}

}
