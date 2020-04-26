package com.caowei;

import java.util.Arrays;

public class StringDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abcdefghijk12345";
		char c = str.charAt(3);
		System.out.println(c);
		
		System.out.println(str.toCharArray());
		
		char[] cs = {'a','b','c','d'};
		String s = new String(cs);
		System.out.println(s);
		
		String s2 = new String(cs,0,2);
		System.out.println(s2);
		
		System.out.println(Arrays.toString(str.getBytes()));
		
		System.out.println(str.replace('a','*'));
		System.out.println(str.replaceAll("\\d", "w"));
		System.out.println(str.substring(0,4));
		System.out.println(Arrays.toString(str.split("e")));
		System.out.println(str);
		System.out.println(str.lastIndexOf('4'));
		System.out.println(str.isEmpty());
		System.out.println(str.length());
		System.out.println(str.toUpperCase());
		System.out.println(str.trim());
		System.out.println(str.concat("****"));
		System.out.println(str+"000");
		str = str+"000";
		System.out.println(str);
	}

}
