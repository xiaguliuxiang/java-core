package javacore.io.day19;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * IO流(BufferedWriter)<br>
 * <p>
 * 缓冲区的出现时为了提高流的操作效率二出现的。<br>
 * 所以在创建缓冲区之前，必须要先有流对象。<br>
 * 
 * 该缓冲区中提供了一个跨平台的换行符。<br>
 * newLine();<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day19-01-IO流(BufferedWriter)
 */
public class BufferedWriterDemo {

	public static void main(String[] args) throws IOException {
		// 创建一个字符写入流对象。
		FileWriter fw = new FileWriter("file" + File.separator + "BufferedWriterDemo_dist.txt");

		/**
		 * 为了提高字符写入流效率，加入了缓冲技术。<br>
		 * 只要将需要被提高效率的流对象作为参数传递给缓冲区的构造函数即可。<br>
		 */
		BufferedWriter bufw = new BufferedWriter(fw);

		for (int i = 0; i < 5; i++) {
			bufw.write("BufferedWriterDemo" + i);
			bufw.newLine();
			bufw.flush();
		}

		// 记住，只要用到缓冲区，就要记得刷新。
		// bufw.flush();

		// 其实关闭缓冲区，就是在关闭缓冲区中的流对象。
		bufw.close();

	}

}
