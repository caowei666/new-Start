package com.caowei;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cat cat = new Cat("Ð¡°×ß÷",3);
		try {
			Cat newCat = (Cat)cat.clone();
			System.out.println("cat="+cat.toString());
			System.out.println("newCat="+newCat);
			System.out.println(cat == newCat);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
