package com.caowei;

import java.util.Arrays;
import java.util.Comparator;

public class LambdaDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		IEat ieat = new IEatImpl();
//		ieat.eat();
		//接口式匿名内部类
//		IEat ieat2 = new IEat() {
//			public void eat() {
//				System.out.println("eat banana");
//			}
//		};
//		ieat2.eat();
		//lambda表达式写法
		//好处1、代码简洁.2、不会单独生成class文件
//		IEat ieat3 = ()->{
//			System.out.println("eat orange");
//		};
//		IEat ieat3 = () -> System.out.println("eat orange");
//		ieat3.eat();
		
		//带参数时使用,参数类型可以省略
//		IEat ieat3 = (thing,name)->System.out.println("eat..."+thing+".."+name);
//		ieat3.eat("people","大兵");
		
		//带返回值的方法
//		IEat ieat = (thing,name)->{
//			System.out.println(name+" eat"+thing);
//			return 10;
//		};
//		ieat.eat("people", "大兵");
		
		//带返回值的方法中只有一句实现代码
		IEat ieat3 = (thing,name)->10; //自动return
		int i = ieat3.eat("people", "大兵");
		System.out.println(i);
		
		Student[] student = {new Student("张三",18),new Student("张二",10),new Student("张一",20)};
//		Arrays.sort(student,new Comparator<Student>() {
//			public int compare(Student o1,Student o2) {
//				return o1.getAge()-o2.getAge();
//			}
//		});
//		Comparator<Student> c = (o1,o2)->o1.getAge()-o2.getAge();
		Arrays.sort(student,(o1,o2)->o1.getAge()-o2.getAge());
		System.out.println(Arrays.toString(student));
		IEat.method();
		
	}

}


//只有一个抽象方法的接口
//interface IEat{
//	public int eat(String thing,String name);
//}
interface IEat{
	public int eat(final String thing,final String name);
	public default void print() {    //有默认方法没关系
		System.out.println("print test");
	}
	public static void  method() {   //静态方法也不受影响
		System.out.println("static method");
	}
}
//class IEatImpl implements IEat{
//	public void eat(String thing) {
//		System.out.println("eat--"+thing);
//	}
//}
