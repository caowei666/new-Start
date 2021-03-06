package com.caowei;

import java.util.HashMap;
import java.util.Map;

public class MapNewMethodDemo {

	public static void main(String[] args) {
		Map<Integer,String> map = new HashMap<>();
		map.put(1, "jack");
		map.put(2, "tom");
		map.put(3, "lily");
//		String value = map.getOrDefault(5, "null");
//		System.out.println(value);
//		String s = map.get(5);
//		System.out.println(s);
		
//		map.put(3,"caowei");  //会将原来的3lily覆盖
//		map.forEach((key,v)->System.out.println(key+v));
//		map.putIfAbsent(3, "caowei");  //3已经存在不会覆盖（不再写入）
//		map.forEach((key,v)->System.out.println(key+v));
		
//		map.remove(1, "jack"); //key和value都匹配才删除
//		map.forEach((key,v)->System.out.println(key+v));
		
//		map.replace(3, "awei");
//		map.replace(3, "awei", "aa");
//		map.forEach((key,v)->System.out.println(key+v));
		
//		map.compute(2, (k,v1)->v1+"1");
//		map.computeIfAbsent(4, (val)->val+"test");//如果4不存在才添加
//		map.forEach((key,v)->System.out.println(key+v));
		
		map.merge(1, "123", (oldVal,newVal)->oldVal.concat(newVal));//如果1存在则返回1的val+888否则添加1，888
		map.forEach((key,v)->System.out.println(key+v));
	}

}
