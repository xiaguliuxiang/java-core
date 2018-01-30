package javacore.io.day21;

import java.io.IOException;
import java.util.Arrays;

/**
 * 字符编码<br>
 * <p>
 * 编码：字符串变成字节数组。<br>
 * String-->byte[]:str.getBytes(charsetName);<br>
 * 解码：字节数组变成字符串。<br>
 * byte[]-->String:new String(byte[], charsetName);<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day21-07-字符编码
 */
public class EncodeDemo {

	public static void main(String[] args) throws IOException {
		String s = "你好";

		byte[] b1 = s.getBytes("UTF-8");
		System.out.println(Arrays.toString(b1));

		String s1 = new String(b1, "ISO8859-1");
		System.out.println("s1 = " + s1);

		// 对s1进行ISO8859-1编码。
		byte[] b2 = s1.getBytes("ISO8859-1");
		System.out.println(Arrays.toString(b2));

		String s2 = new String(b2, "GBK");
		System.out.println("s2 = " + s2);

		String s3 = new String(b1, "UTF-8");
		System.out.println("s3 = " + s3);

	}

}
