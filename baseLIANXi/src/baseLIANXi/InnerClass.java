package baseLIANXi;
/**
 * 
 * 内部类分为成员内部类 、方法内部类、静态内部类、匿名内部类
 * 
 * 成员内部类，在一个类中定义的类
 * 
 * 方法内部类，在一个类的方法内定义一个类
 * 	方法内部类只能定义该内部类的方法内实例化，不可以在此方法外对其实例化；
 * 	方法内部类只能使用用final修饰的变量；
 * 
 * 静态内部类，在类内部中定义一个静态修饰的类
 * 		静态的含义是内部类可以像其他静态成员一样，没有外部类对象时也能够访问它，静态嵌套类仅能访问外部类的静态成员和方法
 *
 *匿名内部类，
 *	不能有构造方法，只能有一个实例；
 *	不能定义任何静态成员、静态方法；
 *	不能式public protected private static;
 *	一定是在new的后面，用其隐含实现一个接口或继承一个类；
 *	匿名内部类为局部的，所以局部内部类的所有限制都对其生效
 */
public class InnerClass {
public static void main(String[] args) {
	outer outer = new outer();
//	outer.inner inner = outer.new inner();
//	inner.print();
	outer.innerPrint();
	outer.show(100);
	outer.print1();
	outer.print2();
	outer.inner3 inner3 = new outer.inner3();
	inner3.print();
	outer.print3(new Eat() {

		@Override
		public void eat() {
			// TODO Auto-generated method stub
			System.out.println("参数式匿名内部类");
		}
		
	});
}
}

class outer{
	public void innerPrint() {
		inner inner = new inner();
		inner.print();
	}
	//成员内部类
	private class inner{
		public  void print() {
			System.out.println("成员内部类");
		}
	}
	//方法内部类
	public void show(int i) {
//		final int x = 10;   //方法内部类只能使用用final修饰的变量
		i++;
		System.out.println(i);
		int y = 10;
		class inner2{
			public void print() {
				System.out.println("方法内部类"+y);
			}
		}
		inner2 inner2 = new inner2();
		inner2.print();
	}
	//静态内部类   优先使用（不会导致内存泄漏）
	static class inner3{
		public void print() {
			System.out.println("静态内部类");
		}
	}
	//匿名内部类
	//继承式	
	public void print1() {
		Cat cat = new Cat() {
			public void eat() {
				System.out.println("继承式匿名内部类");
			}
		};
		cat.eat();
	}
	//接口式
	public void print2() {
		Eat eat = new Eat() {
			public void eat() {
				System.out.println("接口式匿名内部类");
			}
		};
		eat.eat();
	}
	//参数式
	public void print3(Eat eat) {
		eat.eat();
	}
}
interface Eat{
	public void eat();
}
abstract class Cat{
	abstract public void eat();
	public void name() {
		System.out.println(123);
	}
}
/**
 * 方法内部类访问局部变量为什么必须用final ,为什么？
 * 		当调用这个方法的时候，局部变量如果没有用final修饰，他的生命周期和方法的生命周期一样的
 * 	当方法被调用时会入栈，方法结束即出栈，这个局部变量也就消失了，而类的实例化对象需要GC回收
 * 	不会马上消失想用这个局部变量，显然已经不能用了，如果用final修饰会在类加载的时候进入常量
 * 池，即使方法出栈，常量池的常量还在，也就可以继续使用。（JDL1.8取消了在方法内部类中必须显示
 * 的使用final修饰，编译器默认会为这个变量加上final）
 */ 

/**
 * 内部类的作用:每个内部类都能独立的继承自一个（接口的）实现，所以无论外部类是否已经继承了某个（接口的）
 * 实现，对于内部类都没有影响，如果没有内部类提供的可以继承多个具体的或抽象的类的能力，一些设计与
 * 编程问题就很难解决。从这个角度看，内部类使得多重继承的解决方案变的完整，接口解决了部分问题
 * 而内部类有效的实现了”多重继承“。
 */
