package baseLIANXi;

public class arrayTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] cs = {'a','b','c','d','e','f','g'};
		int len = cs.length;
		for(int i=1;i<=len;i++) {
			for(int j=i;j<len;j++) {
				System.out.print(" ");
			}
			for(int j=1;j<=i*2-1;j++) {
				System.out.print(cs[i-1]);
			}
			System.out.println();
		}
	}

}
