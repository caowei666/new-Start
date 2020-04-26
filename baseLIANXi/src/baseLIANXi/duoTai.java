package baseLIANXi;

/**
 * 什么是多态：对象在运行中的多种状态；
 * 多态分为两类：（1）方法的重载和重写，（2）对象的多态性
 * 向上转型：自动转换
 *	向下转型：强制转换
 */

public class duoTai {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//类型转换，用父类的引用指向子类对象，向上转型，自动转换		
		Chicken yj = new YeChicken("小野鸡");
//		yj.eat();
		Chicken jj = new HomeChicken("小家鸡");
//		jj.eat();
//		yj = jj;
//		yj.eat();
//		eat(yj);
//		eat(jj);
		Chicken jjj = new jianjiaoChicken();
//		jjj.eat();
		eat(jjj);
	}
	public static void eat(Chicken c) {
		System.out.println("鸡吃饭");
		c.eat();
		jianjiaoChicken jjj = (jianjiaoChicken)c;
		jjj.song();
	}
}
//父类抽象鸡
abstract class Chicken{
	private String name;
	public Chicken() {}
	public Chicken(String name) {
		this.name = name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public abstract void eat();
}
//子类 家鸡
class HomeChicken extends Chicken{
	public HomeChicken(String name) {
		super(name);
	}
	public void eat() {
		System.out.println(this.getName()+",我爱吃米");
	}
}
class YeChicken extends Chicken{
	public YeChicken(String name) {
		super(name);
	}
	public void eat() {
		System.out.println(this.getName()+",我爱吃虫子");
	}
}
//子类 玩具鸡
class jianjiaoChicken extends Chicken{
	public void eat() {
		System.out.println("我是尖椒鸡，我不吃东西");
	}
	public void song() {
		System.out.println("唧唧复唧唧，我是尖叫鸡");
	}
}
