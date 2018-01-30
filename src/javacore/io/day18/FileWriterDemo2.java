package javacore.io.day18;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * IO流(IO异常处理方式)<br>
 * <p>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day18-08-IO流(IO异常处理方式)
 */
public class FileWriterDemo2 {

	public static void main(String[] args) {

		FileWriter fw = null;
		try {
			fw = new FileWriter("file" + File.separator + "FileWriterDemo2_dist.txt");

			fw.write("FileWriterDemo2\r\nFileWriterDemo2");

		} catch (IOException e) {
			System.out.println("catch:" + e.toString());
		} finally {
			try {
				if (fw != null) {
					fw.close();
				}
			} catch (IOException e) {
				System.out.println("catch:" + e.toString());
			}
		}
	}
}
