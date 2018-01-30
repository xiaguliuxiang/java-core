package javacore.io.day18;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * IO流(拷贝文本文件)<br>
 * IO流(拷贝文本文件图例)<br>
 * <p>
 * 将C盘一个文本文件复制到D盘。<br>
 * 复制的原理：<br>
 * 其实就是将C盘下的文件数据存储到D盘的一个文件中。<br>
 * 
 * 步骤：<br>
 * 1、在D盘创建一个文件，用于存储C盘文件中的数据。<br>
 * 2、定义读取流和C盘文件关联。<br>
 * 3、通过不断的读写完成数据存储。<br>
 * 4、关闭资源。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day18-13-IO流(拷贝文本文件)
 * @see 传智播客毕向东Java基础视频教程-day18-14-IO流(拷贝文本文件图例)
 */
public class CopyText {

	public static void main(String[] args) throws IOException {
		copy_1();
		copy_2();
	}

	/**
	 * 从C盘度一个字符，就往D盘写一个字符。<br>
	 */
	public static void copy_1() throws IOException {
		// 创建目的地。
		FileWriter fw = new FileWriter("file" + File.separator + "CopyText_copy_1_dist.txt");

		// 与已有文件关联。
		FileReader fr = new FileReader("file" + File.separator + "src.txt");

		int ch = 0;

		while ((ch = fr.read()) != -1) {
			fw.write(ch);
		}

		fw.close();
		fr.close();
	}

	public static void copy_2() {
		FileWriter fw = null;
		FileReader fr = null;
		try {
			fw = new FileWriter("file" + File.separator + "CopyText_copy_2_dist.txt");
			fr = new FileReader("file" + File.separator + "src.txt");

			char[] buf = new char[1024];

			int len = 0;
			while ((len = fr.read(buf)) != -1) {
				fw.write(buf, 0, len);
			}

		} catch (IOException e) {
			throw new RuntimeException("读写失败!");
		} finally {
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {

				} finally {

				}
			}
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {

				} finally {

				}
			}
		}
	}
}
