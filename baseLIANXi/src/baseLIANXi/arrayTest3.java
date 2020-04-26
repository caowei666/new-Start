package baseLIANXi;

public class arrayTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] n = {4,7,88,76,90,21,33};
		int m = max(n);
		System.out.println(m);
	}
	public static int max(int[] num) {
		int max = num[0];
		for(int i=1;i<num.length;i++) {
			if(num[i]>max) {
				max = num[i];
			}
		}
		return max;
	}
}
