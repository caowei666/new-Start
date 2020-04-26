package baseLIANXi;

public class overload {
	public static void main(String[] args) {
		int result = add(20,30);
		System.out.println(result);
	}
	public static int add(int a,int b) {
		return a+b;
	}
	public static float add(float a,float b) {
		return a+b;
	}
}
