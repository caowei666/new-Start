package com.caowei;

import java.util.Comparator;

public class DogComparator implements Comparator<Dog> {

	@Override
	public int compare(Dog o1, Dog o2) {
		// TODO Auto-generated method stub
//		return 0;
		return o1.getAge() - o2.getAge();
	}
	
}
