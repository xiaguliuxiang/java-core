package javacore.net.day23;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 网络编程(TCP传输)<br>
 * <p>
 * TCP传输：<br>
 * Socket和ServerSocket.<br>
 * 建立客户端和服务器端。<br>
 * 建立连接后，通过Socket中的IO流进行数据的传输。<br>
 * 关闭Socket.<br>
 * 同样，客户端与服务器端是两个独立的应用程序。<br>
 * <p>
 * 演示TCP传输。<br>
 * 1.TCP分客户端和服务端。<br>
 * 2.客户端对应的对象是Socket.<br>
 * 服务端对应的对象是ServerSocket.<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day23-11-网络编程(TCP传输)
 */
public class TcpDemo {
	public static void main(String[] args) {

	}
}

/**
 * 客户端。<br>
 * <p>
 * 通过查阅Socket对象，发现在该对象建立时，就可以去连接指定主机。<br>
 * 因为TCP是面向连接的，所以在建立Socket服务时，<br>
 * 就要有服务端存在，并连接成功。形成通路后，在该通道进行数据的传输。<br>
 * <p>
 * 步骤：<br>
 * 1.创建Socket服务，并指定要连接的主机和端口。<br>
 */
class TcpClient {
	public static void main(String[] args) throws IOException {
		// 创建客户端的Socket服务，并指定目的主机和端口
		Socket s = new Socket("192.168.159.1", 10003);

		// 为了发送数据，应该获取Socket流中的输出流。
		OutputStream out = s.getOutputStream();

		out.write("tcp is coming".getBytes());

		s.close();
	}
}

/**
 * 需求：定义端点接收数据并打印在控制台上。<br>
 * <p>
 * 服务端：<br>
 * 1.建立服务端的Socket服务。<br>
 * 2.获取连接过来的客户端对象。<br>
 * 通过ServerSocket的accept()方法，没有连接就会等，所以这个方法是阻塞式的。<br>
 * 3.客户端如果发过来数据，那么服务端要使用对应的客户端对象，<br>
 * 并获取到该客户端对象的读取流来读取发过来的数据，并打印在控制台。<br>
 * 4.关闭服务端。<br>
 */
class TcpServer {
	public static void main(String[] args) throws IOException {
		// 建立服务端Socket服务，并监听一个端口。
		ServerSocket ss = new ServerSocket(10003);

		// 通过accept()方法胡群殴连接过来的客户端对象。
		Socket s = ss.accept();

		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip + "...connected");

		// 获取客户端发送过来的数据，那么要使用客户端对象的读取刘来读取数据。
		InputStream in = s.getInputStream();

		byte[] buf = new byte[1024];
		int len = in.read(buf);

		System.out.println(new String(buf, 0, len));

		s.close(); // 关闭客户端

		ss.close();
	}
}