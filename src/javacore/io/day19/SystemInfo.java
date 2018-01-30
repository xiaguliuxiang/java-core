package javacore.io.day19;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

/**
 * IO流(系统信息)<br>
 * <p>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day19-22-IO流(系统信息)
 */
public class SystemInfo {

	public static void main(String[] args) throws IOException {
		Properties prop = System.getProperties();

		System.out.println(prop);
		prop.list(System.out);
		prop.list(new PrintStream("file" + File.separator + "SystemInfo.txt"));

	}
}
