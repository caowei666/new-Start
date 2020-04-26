package baseLIANXi;

public class array1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//创建数组4种方式
		//第一种		
		int[] nums = new int[50];
		for(int i=0;i<50;i++) {
			nums[i] = i;
		}
		//第二种
		int[] num2;
		num2 = new int[50];
		//第三种
		int[] num3 = new int[] {1,2,3,4,5,6};
		//第四种
		int[] num4 = {1,2,3,4};
		System.out.println(num4.length);
		for(int i=0;i<num4.length;i++) {
			System.out.println(num4[i]);
		}
		for(int n:nums) {
			System.out.print(n);
		}
	}
}
