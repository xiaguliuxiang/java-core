package javacore.io.day18;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * IO流(文本文件读取练习)<br>
 * <p>
 * 读取一个.java文件，并打印在控制台上。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day18-12-IO流(文本文件读取练习)
 */
public class FileReaderTest {

	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("file" + File.separator + "src.txt");

		char[] buf = new char[1024];

		int num = 0;

		while ((num = fr.read(buf)) != -1) {
			System.out.println(new String(buf, 0, num));
		}

		fr.close();

	}

}
