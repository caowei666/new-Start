package com.caowei.decorator;

/**
 * 
 * 具体被装饰的类 豆浆
 *
 */
public class SoyaBeanMilk implements Drink {

	@Override
	public float cost() {
		// TODO Auto-generated method stub
		return 10f;
	}

	@Override
	public String description() {
		// TODO Auto-generated method stub
		return "纯豆浆";
	}

}
