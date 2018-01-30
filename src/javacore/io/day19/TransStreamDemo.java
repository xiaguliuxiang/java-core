package javacore.io.day19;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 * IO流(读取键盘录入)<br>
 * IO流(读取转换流)<br>
 * IO流(写入转换流)<br>
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
 * BufferedInputStream<br>
 * BufferedOutputStream<br>
 * 
 * 通过 ReadIn.java 中键盘录入一行数据并打印其大写，发现其实就是读一行数据的原理。<br>
 * 也就是readLine()方法。<br>
 * 
 * readLine()方法是字符流BufferedReader类中的方法。<br>
 * 而键盘录入的read()方法是字节流InputStream的方法。<br>
 * 那么能不能讲字节流转成字符流再使用字符流缓冲区的readLine()方法呢?<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day19-15-IO流(读取键盘录入)
 * @see 传智播客毕向东Java基础视频教程-day19-16-IO流(读取转换流)
 * @see 传智播客毕向东Java基础视频教程-day19-17-IO流(写入转换流)
 */
public class TransStreamDemo {

	public static void main(String[] args) throws IOException {
		// TransStreamDemo_1();
		// TransStreamDemo_2();
		TransStreamDemo_3();
	}

	public static void TransStreamDemo_1() throws IOException {
		// 获取键盘录入对象。
		InputStream in = System.in;

		// 将字节流对象转成字符流对象，使用转换流，InputStreamReader.
		InputStreamReader isr = new InputStreamReader(in);

		// 为了提高效率，将字符串进行缓冲区技术高效操作，使用BufferedReader。
		BufferedReader bufr = new BufferedReader(isr);

		String line = null;

		while ((line = bufr.readLine()) != null) {
			if ("over".equals(line)) {
				break;
			}
			System.out.println(line.toUpperCase());
		}
		bufr.close();
	}

	public static void TransStreamDemo_2() throws IOException {
		// 获取键盘录入对象。
		InputStream in = System.in;

		// 将字节流对象转成字符流对象，使用转换流，InputStreamReader.
		InputStreamReader isr = new InputStreamReader(in);

		// 为了提高效率，将字符串进行缓冲区技术高效操作，使用BufferedReader。
		BufferedReader bufr = new BufferedReader(isr);

		OutputStream out = System.out;
		OutputStreamWriter osw = new OutputStreamWriter(out);
		BufferedWriter bufw = new BufferedWriter(osw);

		String line = null;

		while ((line = bufr.readLine()) != null) {
			if ("over".equals(line)) {
				break;
			}
			bufw.write(line.toUpperCase());
			bufw.newLine();
			bufw.flush();
		}
		bufr.close();
	}

	public static void TransStreamDemo_3() throws IOException {

		// 读取键盘录入的最常见写法
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));

		BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(System.out));

		String line = null;

		while ((line = bufr.readLine()) != null) {
			if ("over".equals(line)) {
				break;
			}
			bufw.write(line.toUpperCase());
			bufw.newLine();
			bufw.flush();
		}
		bufr.close();
	}

}
