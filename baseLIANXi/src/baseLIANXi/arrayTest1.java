package baseLIANXi;

import java.util.Scanner;
import java.util.Random;

public class arrayTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[5];
		Random r = new Random();
		for(int i=0;i<nums.length;i++) {
			nums[i] = r.nextInt(10);
		}
		Scanner input = new Scanner(System.in);
		int userNum = input.nextInt();
		boolean flag = false;
		for(int x:nums) {
			if(userNum == x) {
				flag = true;
				break;
			}
		}
		if(flag) {
			System.out.println("²Â¶ÔÁË");
		}else {
			System.out.println("²Â´íÁË");
		}
	}

}
