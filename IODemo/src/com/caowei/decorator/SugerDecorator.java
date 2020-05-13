package com.caowei.decorator;

/**
 * 具体的装饰者类
 *
 */
public class SugerDecorator extends Decorator {

	public SugerDecorator(Drink drink) {
		super(drink);
	}
	@Override
		public float cost() {
			// TODO Auto-generated method stub
			return super.cost()+1.0f;
		}
	@Override
	public String description() {
		// TODO Auto-generated method stub
		return super.description()+"+糖";
	}
}
