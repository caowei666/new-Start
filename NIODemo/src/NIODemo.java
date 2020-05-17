import java.nio.ByteBuffer;

public class NIODemo {

	public static void main(String[] args) {
		//创建一个字节缓冲区，申请的内存空间为8字节
		ByteBuffer buf = ByteBuffer.allocate(8);
		System.out.println("position="+buf.position());  //0
		System.out.println("limit="+buf.limit());  //8
		System.out.println("capacity="+buf.capacity());  //8
		//向缓存区写数据
		buf.put((byte)10);
		buf.put((byte)20);
		buf.put((byte)30);
		buf.put((byte)40);
		System.out.println("position="+buf.position()); //4
		System.out.println("limit="+buf.limit());  //8
		System.out.println("capacity="+buf.capacity());  //8
		
		//缓冲区反转  用来取值
		buf.flip();
		System.out.println("position="+buf.position()); //0
		System.out.println("limit="+buf.limit());  //4
		System.out.println("capacity="+buf.capacity());  //8
		//告知当前位置和限制之间是否有元素
		if(buf.hasRemaining()) {
			//返回当前位置与限制之间的元素数
			for(int i = 0;i<buf.remaining();i++) {
				byte b = buf.get(i);
				System.out.println(b);
			}
		}
		System.out.println("position="+buf.position()); //0
		System.out.println("limit="+buf.limit());  //4
		System.out.println("capacity="+buf.capacity());  //8
	}

}
