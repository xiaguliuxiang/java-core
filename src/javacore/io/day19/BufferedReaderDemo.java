package javacore.io.day19;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * IO流(BufferedReader)<br>
 * <p>
 * 字符读取流缓冲区<br>
 * 该缓冲区提供了一个一次读一行的方法 readLine(),方便于对文本数据的获取。<br>
 * 当返回null时，表示读到文件末尾。<br>
 * 
 * readLine() 方法返回的时候只返回回车符之前的数据内容，并不反悔回车符。<br>
 * readLine() 方法的原理。<br>
 * 无论是读一行，还是获取多个字符。其实最终都是在硬盘上一个一个读取。<br>
 * 所以最后在哪个使用的还是read()方法一次读一个的方法。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day19-02-IO流(BufferedReader)
 */
public class BufferedReaderDemo {

	public static void main(String[] args) throws IOException {
		// 创建一个读取流对象和文件相关联。
		FileReader fr = new FileReader("file" + File.separator + "src.txt");

		// 为了提高效率，加入缓冲技术，将字符读取流对象作为参数传递给缓冲对象的构造函数。
		BufferedReader bufr = new BufferedReader(fr);

		String line = null;

		while ((line = bufr.readLine()) != null) {
			System.out.println(line);
		}

		bufr.close();
	}

}
