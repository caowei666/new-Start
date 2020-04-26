package baseLIANXi;

/**
 * 抽象类：用abstract关键字声明的类称为抽象类
 * 	抽象类可以没有抽象方法；
 *	非抽象类继承抽象类必须实现所有的抽象方法；
 *	抽象类可以继承抽象类，可以不实现父类抽象方法；
 *	抽象类可以有方法和属性；
 *	抽象类不能被实例化；
 *	抽象类不能声明为final；
 *	抽象类可以有构造方法；
 */

public class Abstract {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Man man = new Man();
		man.move();
		man.eat();
		man.sleep();
		
		Woman woman = new Woman();
		woman.eat();
		woman.move();
		woman.sleep();
	}

}

abstract class Animal{
	public abstract void move();
}

abstract class Person extends Animal{
	public abstract void eat();
	public void sleep() {
		System.out.println("人爱睡觉");
	}
}

class Man extends Person{
	public void move() {
		System.out.println("我是男人，我爱跑步");
	}
	public void eat() {
		System.out.println("我是男人，我爱吃肉");
	}
}
class Woman extends Person{
	public void move() {
		System.out.println("我是女人，我爱逛街");
	}
	public void eat() {
		System.out.println("我是女人，我爱吃香蕉");
	}
}