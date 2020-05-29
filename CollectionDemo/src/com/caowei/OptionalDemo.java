package com.caowei;

import java.util.Optional;

public class OptionalDemo {

	public static void main(String[] args) {
		//创建optional对象的方式
		Optional<String> optional = Optional.of("bin");
		//Optional<String> optional2 = Optional.ofNullable("bin");
		Optional<String> optional3 = Optional.empty(); 
		
		System.out.println(optional.isPresent()); //true
		
		System.out.println(optional.get());  //bin
		
		optional.ifPresent((value)->System.out.println(value)); //bin
		
		System.out.println(optional3.orElse("无值"));  //无值
		
		System.out.println(optional3.orElseGet(()->"default"));
		
//		try {
//			optional3.orElseThrow(Exception::new);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		Optional<String> optional4 = optional.map((value)->value.toUpperCase());
		System.out.println(optional4.orElse("not found"));
		
		Optional<String> optional5 = optional.flatMap((value)->Optional.of(value.toUpperCase()+"flatMap"));
		System.out.println(optional5.orElse("not found"));
		
		optional5 = optional.filter((value)->value.length()>3);
		System.out.println(optional5.orElse("not dayu3"));
	}

}
