package com.caowei;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 
 * Stream接口：不是存储结构，数据源来源可以是一个集合，为了函数式编程，
 *惰性执行，数据只能被消费一次
 *
 *两种类型的操作方法：1、中间操作（生成一个Stream）。2、结束操作(执行计算操作)
 */
public class StreamDemo {
	public static void main(String[] args) {
		//foreach方法
		Stream<String> stream = Stream.of("good","good","study","day","day","up");
		//stream.forEach((str)->System.out.println(str)); //直接打印（结束操作）
		//stream.forEach(System.out::println);
		
		//filter
		//stream.filter((s)->s.length()>3).forEach(System.out::println);  //返回新的流（中间操作）
		
		//distinct去除重复元素（中间操作）
		//stream.distinct().forEach(System.out::println);
		
		//map
		//stream.map(s->s.toUpperCase()).forEach(System.out::println);
		
		//flatMap
		//Stream<List<Integer>> ss = Stream.of(Arrays.asList(1,2,3),Arrays.asList(4,5));
		//ss.flatMap(l->l.stream()).forEach(System.out::println);
		
		//reduce
		//Optional<String> opt = stream.reduce((s1,s2)->s1.length()>=s2.length()?s1:s2);
		//System.out.println(opt.get());
		
		//collect
		List<String> list = stream.collect(Collectors.toList());
		list.forEach(s->System.out.println(s));
		
		//::方法引用
		//引用静态方法  Integer::valueOf
		//应用对象的方法  list::add
		//引用构造方法  ArrayList::new
	}
}
