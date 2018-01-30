package javacore.io.day19;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * IO流(异常的日志信息)<br>
 * <p>
 * 将异常信息保存到文件中。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day19-21-IO流(异常的日志信息)
 */
public class ExceptionInfo {

	public static void main(String[] args) {
		try {
			int[] arr = new int[2];
			System.out.println(arr[3]);
		} catch (Exception e) {
			try {

				Date d = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				String s = sdf.format(d);

				PrintStream ps = new PrintStream("file" + File.separator + "ExceptionInfo.log");
				ps.println(s);
				System.setOut(ps);
			} catch (IOException ex) {
				throw new RuntimeException("日志文件创建失败!");
			}
			e.printStackTrace(System.out);
		}
	}
}
