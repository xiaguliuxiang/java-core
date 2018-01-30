package javacore.net.day24;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 网络编程(浏览器客户端-自定义服务端)<br>
 * 网络编程(浏览器客户端-Tomcat服务端)<br>
 * 网络编程(自定义浏览器-Tomcat服务端)<br>
 * <p>
 * 演示客户端和服务端。<br>
 * 1.<br>
 * 客户端：浏览器(telnet)<br>
 * 服务端：自定义。<br>
 * 2.<br>
 * 客户端：浏览器。<br>
 * 服务端：tomcat服务器。<br>
 * <p>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day24-04-网络编程(浏览器客户端-自定义服务端)
 * @see 传智播客毕向东Java基础视频教程-day24-05-网络编程(浏览器客户端-Tomcat服务端)
 * @see 传智播客毕向东Java基础视频教程-day24-06-网络编程(自定义浏览器-Tomcat服务端)
 */
public class ServerDemo {
	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(11000);

		Socket s = ss.accept();

		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip);

		InputStream in = s.getInputStream();

		byte[] buf = new byte[1024];

		int len = in.read(buf);

		System.out.println(new String(buf, 0, len));

		PrintWriter out = new PrintWriter(s.getOutputStream(), true);

		out.println("<font color='red' size='7'>hello, client</font>");

		s.close();

		ss.close();

	}
}

/**
 * 信息来自:IE 11.545.10685.0<br>
 * 
 * <pre>
 * GET / HTTP/1.1
 * Accept: text/html, application/xhtml+xml, image/jxr, *\/*(此处添加\进行转义)
 * Accept-Language: zh-CN
 * User-Agent: Mozilla/5.0 (Windows NT 10.0; WOW64; Trident/7.0; rv:11.0) like Gecko
 * Accept-Encoding: gzip, deflate
 * Host: 192.168.159.1:11000
 * Connection: Keep-Alive
 * </pre>
 */
