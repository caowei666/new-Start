package baseLIANXi;

/**
 * 	接口中只能定义抽象方法；
 *	接口中定义的方法没有声明修饰符，默认为public abstract；
 *	接口中只能定义常量；
 *	JDK1.8后新特性：可以定义一个默认的方法，可以被所有实现类继承；
 *	接口可以多继承,类可以实现多个接口；
 *	实现接口必须实现接口所有方法；
 *	抽象类实现接口可以不实现接口的方法；
 *	接口不能有构造方法；
 *	接口不能被实例化；
 */

public class Interface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Girl mm = new Girl("玛丽");
		mm.sleep();
		mm.eat();
		mm.run();
		mm.print();
	}

}

interface IEat{
	public abstract void eat(); //可以简写为void eat();
	public static final int NUM = 10; //可以简写为int NUM=10;
	public default void print() {
		System.out.println("eat");
	}
}
interface IRun{
	public abstract void run();
}
interface ISleep extends IEat,IRun{
	void sleep();
}

class Girl implements ISleep,IEat{
	private String name;
	public Girl(String name) {
		this.name = name;
	}
	public Girl() {}
	public void sleep() {
		System.out.println("我爱睡觉");
	}
	public void eat() {
		System.out.println("我是"+name+"我爱吃葡萄");
	}
	public void run() {
		System.out.println("吃完就跑");
	}
}
