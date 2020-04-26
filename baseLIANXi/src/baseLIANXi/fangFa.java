package baseLIANXi;

import java.util.Scanner;

public class fangFa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input  = new Scanner(System.in);
		System.out.println("请输入要打印星星行数");
		int line = input.nextInt();
		printStar(line);
	}
	public static void printStar(int line) {
		for(int i=1;i<=line;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
