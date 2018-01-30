package javacore.io.day18;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * IO流(文本文件读取方式一)<br>
 * <p>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day18-10-IO流(文本文件读取方式一)
 */
public class FileReaderDemo {

	public static void main(String[] args) throws IOException {

		/**
		 * 创建一个文件读取流对象，和指定名称的文件相关联。<br>
		 * 要保证该文件时已经存在的，如果不存在，会发生异常FileNotFoundException。<br>
		 */
		FileReader fr = new FileReader("file" + File.separator + "src.txt");

		/**
		 * 调用读取流对象的read()方法。<br>
		 * read():一起读取一个字符，而且会自动往下读。<br>
		 */

		while (true) {
			int ch = fr.read();
			if (ch == -1) {
				break;
			}
			System.out.println("ch = " + (char) ch);
		}

		fr.close();
	}
}
