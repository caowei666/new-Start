package baseLIANXi;

public class keBianCanShu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		print(1,2,3,3,2,1);
	}
	//jdk1.5可变参数		
	//可变参数只能是参数列表的最后一个
	//可变参数可以作为数组使用	
	public static void print(int ...x) {
		int len = x.length;
		for(int i=0;i<len;i++) {
			System.out.println(x[i]);
		}
	}

}
