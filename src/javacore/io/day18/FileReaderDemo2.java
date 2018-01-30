package javacore.io.day18;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * IO流(文本文件读取方式二)<br>
 * <p>
 * 第二种方式：通过字符数组进行读取。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day18-11-IO流(文本文件读取方式二)
 */
public class FileReaderDemo2 {

	public static void main(String[] args) throws IOException {

		FileReader fr = new FileReader("file" + File.separator + "src.txt");

		/**
		 * 定义一个字符数组，用于存储读到的字符。<br>
		 * 该read(char[])返回的是读到的字符个数。
		 */
		char[] buf = new char[1024];

		int num = 0;
		while ((num = fr.read(buf)) != -1) {
			System.out.println(new String(buf, 0, num));
		}

		fr.close();

	}
}
