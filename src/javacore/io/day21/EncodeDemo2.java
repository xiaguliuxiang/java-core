package javacore.io.day21;

import java.io.IOException;

/**
 * 字符编码-联通<br>
 * <p>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day21-08-字符编码-联通
 */
public class EncodeDemo2 {

	public static void main(String[] args) throws IOException {
		String s = "联通";

		byte[] by = s.getBytes("GBK");

		for (byte b : by) {
			System.out.println(Integer.toBinaryString(b & 255));
		}

		System.out.println();

	}

}
