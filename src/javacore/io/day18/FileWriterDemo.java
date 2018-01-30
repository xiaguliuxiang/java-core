package javacore.io.day18;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * IO流(概述)<br>
 * IO流(FileWriter)<br>
 * <p>
 * 字符流和字节流：<br>
 * <br>
 * 字节流两个基类：<br>
 * InputStream OutputStream<br>
 * 
 * 字符流两个基类：<br>
 * Reader Writer<br>
 * 
 * 先学习一下字符流的特点。<br>
 * 
 * 既然IO流是用于操作数据的，那么数据的最常见的体现形式是：文件。<br>
 * 
 * 那么先以操作文件为主来演示。<br>
 * 需求：在硬盘上，创建一个文件并写入一些文字数据。<br>
 * 
 * 找到一个专门用于操作文件的Writer子类对象：FileWriter。<br>
 * 后缀名是父类名，前缀名是该流对象的功能。
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day18-06-IO流(概述)
 * @see 传智播客毕向东Java基础视频教程-day18-07-IO流(FileWriter)
 */
public class FileWriterDemo {

	public static void main(String[] args) throws IOException {
		/**
		 * 创建一个FileWriter对象，该对象一被初始化就必须要明确被操作的文件。<br>
		 * 而且该文件会被创建到指定目录下，如果该目录下已有同名文件，将被覆盖。<br>
		 * 其实，该步就是在明确数据要存放的目的地。
		 */
		FileWriter fw = new FileWriter("file" + File.separator + "FileWriterDemo_dist.txt");

		// 调用write()方法，将字符串写入到流中。
		fw.write("abcde");

		// 刷新流对象中的缓冲中的数据，将数据刷到目的地中。
		fw.flush();

		fw.write("haha");

		/**
		 * 关闭流资源，但是关闭之前会刷新一次内部的缓冲中的数据。<br>
		 * 将数据刷到目的地中。<br>
		 * 和flush()区别：<br>
		 * flush刷新后，流可以继续使用，close刷新后，会将流关闭。
		 */
		fw.close();

		try {
			fw.write("haha");
		} catch (IOException e) {
			System.out.println("Stream closed");
		}
	}
}
