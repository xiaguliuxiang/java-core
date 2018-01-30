package javacore.io.day19;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * IO流(字节流File读写操作)<br>
 * <p>
 * 字符流:<br>
 * FileReader<br>
 * FileWriter<br>
 * 
 * BufferedReader<br>
 * BufferedWriter<br>
 * 
 * 字节流:<br>
 * InputStream<br>
 * OutputStream<br>
 * 
 * 需求:<br>
 * 想要操作图片数据，这时就要用到字节流。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day19-11-IO流(字节流File读写操作)
 */
public class FileStream {

	public static void main(String[] args) throws IOException {
		writeFile();
		readFile_1();
		readFile_2();
		readFile_3();
	}

	public static void readFile_3() throws IOException {
		FileInputStream fis = new FileInputStream("file" + File.separator + "src.txt");

		int num = fis.available();
		System.out.println("num = " + num);

		// 定义一个刚刚好的缓冲区，不用再循环了。
		byte[] buf = new byte[fis.available()];
		fis.read(buf);
		System.out.println(new String(buf));

		fis.close();

	}

	public static void readFile_2() throws IOException {
		FileInputStream fis = new FileInputStream("file" + File.separator + "src.txt");

		byte[] buf = new byte[1024];
		int len = 0;
		while ((len = fis.read(buf)) != -1) {
			System.out.println(new String(buf, 0, len));
		}
		fis.close();
	}

	public static void readFile_1() throws IOException {
		FileInputStream fis = new FileInputStream("file" + File.separator + "src.txt");

		int ch = 0;

		while ((ch = fis.read()) != -1) {
			System.out.print((char) ch);
		}
		System.out.println();
		fis.close();
	}

	public static void writeFile() throws IOException {
		FileOutputStream fos = new FileOutputStream("file" + File.separator + "FileStream_writeFile_dist.txt");

		fos.write("abcde".getBytes());

		fos.close();
	}
}
