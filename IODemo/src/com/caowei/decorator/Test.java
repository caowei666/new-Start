package com.caowei.decorator;

public class Test {

	public static void main(String[] args) {
		Drink d = new SoyaBeanMilk();
		SugerDecorator suger = new SugerDecorator(d);
		EggDecorator egg = new EggDecorator(suger);
		BlackBeanDecorator blackBean = new BlackBeanDecorator(egg);
		System.out.println("你点的豆浆是："+blackBean.description());
		System.out.println("一共花了："+blackBean.cost());
	}

}
