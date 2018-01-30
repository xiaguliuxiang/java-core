package javacore.net.day24;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * 网络编程(URL-URLConnection)<br>
 * 网络编程(小知识点)<br>
 * 网络编程(域名解析)<br>
 * <p>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day24-08-网络编程(URL-URLConnection)
 * @see 传智播客毕向东Java基础视频教程-day24-09-网络编程(小知识点)
 * @see 传智播客毕向东Java基础视频教程-day24-10-网络编程(域名解析)
 */
public class URLConnectionDemo {
	public static void main(String[] args) throws IOException {
		URL url = new URL("http://127.0.0.1:8080/index.jsp?name=admin&password=admin");

		URLConnection conn = url.openConnection();
		System.out.println(conn);

		InputStream in = conn.getInputStream();

		byte[] buf = new byte[1024];

		int len = in.read(buf);

		System.out.println(new String(buf, 0, len));
	}
}
