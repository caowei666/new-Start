import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
/**
 * 
 * IO操作性能比较
 * 1、内存映射最快
 * 2、NIO读写文件
 * 3、使用了缓存的IO流
 * 4、无缓存的IO流
 *
 */
public class CopyFileDemo {
	private static void randomAccessFileCopy() {
		try {
			RandomAccessFile in = new RandomAccessFile("c:\\Abstract1.jpg","r");
			RandomAccessFile out = new RandomAccessFile("c:\\test\\Abstract1.jpg","rw");
			FileChannel fcIn = in.getChannel();
			FileChannel fcOut = out.getChannel();
			long size = fcIn.size();  //输入流字节大小
			//输入流的缓冲区
			MappedByteBuffer inBuf = fcIn.map(MapMode.READ_ONLY, 0, size);
			//输出流的缓冲区
			MappedByteBuffer outBuf = fcOut.map(MapMode.READ_WRITE, 0, size);
			for(int i = 0;i < size;i++) {
				outBuf.put(inBuf.get());
			}
			//关闭通道时会写入数据块
			fcIn.close();
			fcOut.close();
			in.close();
			out.close();
			System.out.println("copy success");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 通过文件通道实现文件复制
	 */
	private static void copyFile() {
		try {
			//创建输入流文件通道
			FileChannel fcIn = new FileInputStream("c:\\Abstract1.jpg").getChannel();
			//创建一个输出文件通道
			FileChannel fcOut = new FileOutputStream("c:\\test\\Abstract1.jpg").getChannel();
			ByteBuffer buf = ByteBuffer.allocate(1024);
			while((fcIn.read(buf))!=-1) {
				buf.flip();
				fcOut.write(buf);
				buf.clear();
			}
			fcIn.close();
			fcOut.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
//		copyFile();
		randomAccessFileCopy();
	}

}
