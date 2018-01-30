package javacore.io.day19;

import java.io.IOException;
import java.io.InputStream;

/**
 * IO流(读取键盘录入)<br>
 * IO流(读取转换流)<br>
 * <p>
 * 读取键盘录入。<br>
 * System.out:对应的是标准输出设备：控制台。<br>
 * System.in:对应的标准输入设备：键盘。<br>
 * 
 * 需求：<br>
 * 通过键盘录入数据。<br>
 * 当录入一行数据后，就将该行数据进行打印。<br>
 * 如果录入的数据是orver,那么停止录入。
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day19-15-IO流(读取键盘录入)
 * @see 传智播客毕向东Java基础视频教程-day19-16-IO流(读取转换流)
 */
public class ReadIn {

	public static void main(String[] args) throws IOException {
		InputStream in = System.in;

		// 换行符的ASCII码值
		System.out.println('\r' + 0);
		System.out.println('\n' + 0);

		StringBuilder sb = new StringBuilder();
		while (true) {
			int ch = in.read();
			if (ch == '\r') {
				continue;
			}
			if (ch == '\n') {
				String s = sb.toString();
				if ("over".equals(s)) {
					break;
				}
				System.out.println(s.toUpperCase());
				// 清除缓冲区
				sb.delete(0, sb.length());
			} else {
				sb.append((char) ch);
			}
		}

	}

}
