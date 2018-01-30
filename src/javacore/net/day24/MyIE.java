package javacore.net.day24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 网络编程(自定义浏览器-Tomcat服务端)<br>
 * <p>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day24-06-网络编程(自定义浏览器-Tomcat服务端)
 */
public class MyIE {
	public static void main(String[] args) throws IOException {
		Socket s = new Socket("192.168.159.1", 8080);

		PrintWriter out = new PrintWriter(s.getOutputStream(), true);

		out.println("GET / HTTP/1.1");
		out.println("Accept: */*");
		out.println("Accept-Language: zh-CN");
		out.println("Host: 192.168.159.1:8080");
		out.println("Connection: Keep-Alive");

		out.println();
		out.println();

		BufferedReader bufr = new BufferedReader(new InputStreamReader(s.getInputStream()));

		String line = null;

		while ((line = bufr.readLine()) != null) {
			System.out.println(line);
		}
		s.close();

	}
}
