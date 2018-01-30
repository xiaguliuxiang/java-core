package javacore.net.day24;

import java.io.IOException;
import java.net.URL;

/**
 * 网络编程(URL-URLConnection)<br>
 * <p>
 * String getFile();获取此URL的文件名。<br>
 * String getHost();获取此URL的主机名(如果适用).<br>
 * String getPath();获取此URL的路径部分。<br>
 * String getPort();获取此URL的端口号。<br>
 * String getProtocol();获取此URL的协议名称。<br>
 * String getQuery();获取此URl的查询部分。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day24-08-网络编程(URL-URLConnection)
 */
public class URLDemo {
	public static void main(String[] args) throws IOException {
		URL url = new URL("http://127.0.0.1:8080/index.jsp?name=admin&password=admin");
		System.out.println("getProtocol():" + url.getProtocol());
		System.out.println("getHost():" + url.getHost());
		System.out.println("getPort():" + url.getPort());
		System.out.println("getPath():" + url.getPath());
		System.out.println("getFile():" + url.getFile());
		System.out.println("getQuery():" + url.getQuery());

	}
}
