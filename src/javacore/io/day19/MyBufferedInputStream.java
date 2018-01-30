package javacore.io.day19;

import java.io.IOException;
import java.io.InputStream;

/**
 * 自定义字节流的缓冲区-read和write的特点。<br>
 * <p>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day19-14-IO流(自定义字节流的缓冲区-read和write的特点)
 */
public class MyBufferedInputStream {

	public static void main(String[] args) {

	}

	private InputStream in;

	private byte[] buf = new byte[1024];

	private int pos = 0, count = 0;

	public MyBufferedInputStream(InputStream in) {
		super();
		this.in = in;
	}

	// 一次读一个字节，从缓冲区(字节数组)获取。
	public int myRead() throws IOException {
		// 通过in对象读取硬盘上数据，并存储在buf中。
		if (count == 0) {
			count = in.read(buf);
			if (count < 0) {
				return -1;
			}
			pos = 0;
			byte b = buf[pos];

			count--;
			pos++;
			return b & 255;
		} else if (count > 0) {
			byte b = buf[pos];

			count--;
			pos++;
			return b & 0xff;
		}
		return -1;
	}

	public void myClose() throws IOException {
		in.close();
	}
}

/**
 * 11111111-11111111-0000000<br>
 * byte: -1 --> int : -1;<br>
 * 00000000-00000000-00000000-11111111 255<br>
 * 
 * 11111111-11111111-11111111-11111111 -1<br>
 * 
 * 11111111 --> 提升了一个int类型，那不还是-1吗？<br>
 * 是-1的原因是因为在8个1前面补的1导致的。<br>
 * 那么我只要在那面补0，既可以保留元字节数据不变，又可以避免-1的出现。<br>
 * 怎么补0呢？<br>
 * 
 * --11111111-11111111-11111111-11111111 -1<br>
 * & 00000000-00000000-00000000-11111111 255<br>
 * -----------------------------------------------<br>
 * --00000000-00000000-00000000-11111111
 * 
 * 0000-0001<br>
 * 1111-1110<br>
 * 0000-0001<br>
 * 1111-1111<br>
 * 
 */
