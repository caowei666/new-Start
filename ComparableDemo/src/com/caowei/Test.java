package com.caowei;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {123,32,32,21,54,65,123,33,55};
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));
		
		String[] name = {"jack","tom","caowei","°¢Î°"};
		Arrays.sort(name);
		System.out.println(Arrays.toString(name));
		
		Cat[] cats = {new Cat("·ß·ß",2),new Cat("·Æ·Æ",3),new Cat("tom",3)};
		Arrays.sort(cats);
		System.out.println(Arrays.toString(cats));
		
		Dog[] dogs = {new Dog("·ß·ß",2),new Dog("·Æ·Æ",7),new Dog("tom",3)};
		Arrays.sort(dogs,new DogComparator());
		System.out.println(Arrays.toString(dogs));
	}

}
