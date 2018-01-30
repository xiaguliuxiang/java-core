package javacore.net.day23;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 网络编程(TCP传输2)<br>
 * <p>
 * 演示TCP的传输的客户端和服务端的互访。<br>
 * 需求：客户端给服务端发送数据，服务端收到后，给客户端反馈信息。<br>
 * <br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day23-12-网络编程(TCP传输2)
 */
public class TcpDemo2 {
	public static void main(String[] args) {

	}
}

/**
 * 客户端：<br>
 * 1.建立Socket服务，指定要连接的主机和端口。<br>
 * 2.获取Socket流中的输出流，将数据写到该流中，通过网络发送给服务端。<br>
 * 3.获取Socket流中的输入流，将服务端反馈的数据获取到，并打印。<br>
 * 4.关闭客户端资源。<br>
 */
class TcpClient2 {
	public static void main(String[] args) throws IOException {
		Socket s = new Socket("192.168.159.1", 10004);

		OutputStream out = s.getOutputStream();
		out.write("client:hello,server".getBytes());

		InputStream in = s.getInputStream();

		byte[] buf = new byte[1024];
		int len = in.read(buf);
		System.out.println(new String(buf, 0, len));

		s.close();
	}
}

/**
 * 服务端<br>
 * <p>
 */
class TcpServer2 {
	public static void main(String[] args) throws IOException, InterruptedException {
		ServerSocket ss = new ServerSocket(10004);

		Socket s = ss.accept();

		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip + "...connected");

		InputStream in = s.getInputStream();

		byte[] buf = new byte[1024];
		int len = in.read(buf);
		System.out.println(new String(buf, 0, len));

		OutputStream out = s.getOutputStream();

		Thread.sleep(1000);
		out.write("server:received".getBytes());

		ss.close();
	}
}