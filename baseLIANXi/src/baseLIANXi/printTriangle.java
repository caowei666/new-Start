package baseLIANXi;

import java.util.Scanner;

public class printTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		print(num);
	}
	public static void print(int line) {
		for(int i=1;i<=line;i++) {
			for(int j=i;j<line;j++) {
				System.out.print(" ");
			}
			for(int j=1;j<i*2-1;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
