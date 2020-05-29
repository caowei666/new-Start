package com.caowei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionsDemo {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("jack");
		list.add("tom");
		list.add("lily");
		//1、顺序操作（主要针对list）
//		Collections.reverse(list);
//		Collections.shuffle(list);  //打乱顺序
//		Collections.sort(list);
//		Collections.swap(list, 0, 1);  //叫喊
//		Collections.rotate(list, 1);  //每个往右挫一个，最后一个变为第一个
		//2、查找和替换(主要针对collection接口)
//		int i = Collections.binarySearch(list, "jack");
//		String i = Collections.max(list);
//		String i = Collections.min(list);
//		Collections.fill(list, "bin");  //所有的元素替换为"bin"
//		int i = Collections.frequency(list, "lily");//"lily"出现的次数
//		Collections.replaceAll(list, "lily", "ww");
		
		//线程安全
//		List<String> synclist = Collections.synchronizedList(new ArrayList<String>());
		
//		List<String> slist = Collections.emptyList(); //返回一个不能添加元素的list
//		slist.add("bin");
//		System.out.println(slist);
		
		List<String> li = query();
		System.out.println(li.size());  //返回null时打印size报错 返回emptyList(),打印结果为0
		
//		Collections.disjoint(c1, c2) //如果两个指定集合中没有相同元素则返回true
//		Collections.addAll(c, elements) //将所有元素添加到指定集合
	}
	
	public static List<String> query(){
		List<String> list = null;
		
		
//		return list;
		return Collections.emptyList();
	}

}
