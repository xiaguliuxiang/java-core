package javacore.io.day20;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * IO流(PrintWriter)<br>
 * <p>
 * 打印流<br>
 * 该流提供了打印方法，可以将各种数据类型的数据都原样打印。<br>
 * <p>
 * 字节打印流：PrintStream.<br>
 * 构造函数可以接收的参数类型：<br>
 * 1、File对象，File。<br>
 * 2、字符串路径，String。<br>
 * 3、字节输出流，OutputStream。<br>
 * 
 * 字符打印流：PrintWriter。<br>
 * 构造函数可以接收的参数类型：<br>
 * 1、File对象，File。<br>
 * 2、字符串路径，String。<br>
 * 3、字节输出流，OutputStream。<br>
 * 3、字符输出流，Writer。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day20-15-IO流(PrintWriter)
 */
public class PrintStreamDemo {

	public static void main(String[] args) throws IOException {
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));

		// PrintWriter out = new PrintWriter(System.out, true);
		PrintWriter out = new PrintWriter(new FileWriter("file" + File.separator + "PrintStreamDemo_dist.txt"), true);

		String line = null;

		while ((line = bufr.readLine()) != null) {
			if ("over".equals(line)) {
				break;
			}
			out.println(line.toUpperCase());
			// out.flush();
		}

		out.close();
		bufr.close();
	}

}
