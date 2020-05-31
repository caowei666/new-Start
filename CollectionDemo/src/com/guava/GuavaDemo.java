package com.guava;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.BiMap;
import com.google.common.collect.Collections2;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;
import com.google.common.collect.Table;
import com.google.common.collect.Table.Cell;

public class GuavaDemo {
	
	//双键map（table）行+列+值
	@Test
	public void testGuava10() {
		Table<String,String,Integer> table = HashBasedTable.create();
		table.put("jack", "java", 80);
		table.put("tom", "php", 90);
		table.put("bin", "ui", 70);
		table.put("lili", "ios", 99);
		Set<Cell<String,String,Integer>> cells = table.cellSet();
		cells.forEach((k1)->System.out.println(k1.getColumnKey()+"-"+k1.getRowKey()+"-"+k1.getValue()));
	}
	//BiMap：双向Map（bidirectional Map）键和值都不能重复
	@Test
	public void testGuava9() {
		BiMap<String,String> map = HashBiMap.create();
		map.put("finaly_test", "18201583398");
		map.put("finaly_test2", "18201583399");
		String name = map.inverse().get("18201583398");
		System.out.println(name);
		System.out.println(map.inverse().inverse().get("finaly_test"));
	}
	//Mulimap:key可以重复
	@Test
	public void testGuava8() {
		Map<String,String> map = new HashMap<>();
		map.put("java从入门到精通", "bin");
		map.put("PHP从入门到精通","bin");
		map.put("Android从入门到静态", "bin");
		map.put("笑看人生", "vince");
		Multimap<String, String> mmap = ArrayListMultimap.create();
		Iterator<Map.Entry<String,String>> iter = map.entrySet().iterator();
		while(iter.hasNext()) {  //遍历map 颠倒存入Mulimap
			Map.Entry<String, String> entry = iter.next();
//			System.out.println(entry);
			mmap.put(entry.getValue(), entry.getKey());
		}
//		System.out.println(mmap);
		mmap.forEach((k,v)->System.out.println(k+"->"+v));
		System.out.println(mmap.size()); //4
	}
	//Multiset:无序可重复
	@Test
	public void testGuava7() {
		String s = "good good study day day up";
		String[] ss = s.split(" ");
		HashMultiset<String> set = HashMultiset.create();
		for(String str:ss) {
			set.add(str);
		}
		Set<String> set2 = set.elementSet();
		for(String str:set2) {
			System.out.println(str+":"+set.count(str));
		}
	}
	//集合操作：交集、差集、并集
	@Test
	public void testGuava6() {
		Set<Integer> set1 = Sets.newHashSet(1,2,3);
		Set<Integer> set2 = Sets.newHashSet(3,4,5);
//		SetView<Integer> v1 = Sets.intersection(set1, set2); //交集
//		System.out.println(v1);
//		set1.retainAll(set2); //交集
//		System.out.println(set1);
		
//		SetView<Integer> v2 = Sets.difference(set1, set2); //差集
//		System.out.println(v2);
		
		SetView<Integer> v3 = Sets.union(set1, set2);  //并集
		System.out.println(v3);
	}
	//组合式函数编程
	@Test
	public void testGuava4() {
		List<String> list = Lists.newArrayList("java","php","jack","h5","json");
		Function<String,String> f1 = new Function<String,String>(){
			@Override
			public String apply(String arg0) {
				return arg0.length()>3?arg0.substring(0, 4):arg0;
			}			
		};
		Function<String,String> f2 = new Function<String,String>(){
			@Override
			public String apply(String arg0) {
				return arg0.toUpperCase();
			}			
		};
		Function<String,String> f = Functions.compose(f1, f2);
		Collection<String> coll = Collections2.transform(list, f);
		coll.forEach(System.out::println);
	}
	
	//转换
	@Test
	public void testGuava3() {
		Set<Long> timeSet = Sets.newHashSet(20121122L,20170502L,20200530L);
		Collection<String> timeCollect = Collections2.transform(timeSet, (value)->new SimpleDateFormat("yyyy-MM-dd").format(value));
		System.out.println(timeCollect);
	}
	//过滤器
	@Test
	public void testGuava2() {
		List<String> list = Lists.newArrayList("java","php","jack","h5","json");
		Collection<String> result = Collections2.filter(list, (e)->e.startsWith("j"));
		System.out.println(result);
	}
	//设置list只读的几种方式
	@Test
	public void testGuava1() {
		System.out.println("test guava");
//		List<String> list = Arrays.asList("jack","tom","lili","bin");
//		list.add("caowei");
		
		List<String> list = new ArrayList<>();
		list.add("tom");
		list.add("jack");
		list.add("lily");
//		List<String> readList = Collections.unmodifiableList(list);
//		readList.add("caowei");
		
		ImmutableList<String> iList = ImmutableList.of("jack","tom","lily","bin");
		iList.add("caowei");
	}
	
}
