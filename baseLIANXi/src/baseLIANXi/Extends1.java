package baseLIANXi;

public class Extends1 {
	public static void main(String[] args) {
		HomeDog h = new HomeDog("哈士奇");
		h.print();
		h.eat();
	}
}

class Dog{
	protected String name;
	private String sex;
	public Dog(String name,String sex) {
		this.name = name;
		this.sex = sex;
		System.out.println("我是Dog的构造方法");
	}
//	public Dog() {
//		System.out.println("我是Dog的无参构造方法");
//	}
	public void eat() {
		System.out.println("吃法");
	}
}
class HomeDog extends Dog{
	public HomeDog(String name) {
		super(name,"公");
		this.name= name;
		System.out.println("我是HomeDog的构造方法");
	}
	public void print() {
		System.out.println(name+"我是一只家狗");
	}
}
