package baseLIANXi;

public class WithReturn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean a = isRunNian(1904);
		System.out.println(a);
	}
	public static boolean isRunNian(int year) {
		if((year%4==0 && year%100!=0) || year%400==0) {
			return true;
		}else {
			return false;
		}
	}
}
