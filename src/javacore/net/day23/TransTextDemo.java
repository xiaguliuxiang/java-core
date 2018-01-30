package javacore.net.day23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 网络编程(TCP练习)<br>
 * <p>
 * 需求：建立一个文本转换服务器。<br>
 * 客户端给服务端发送文本，服务端会将文本转成大写后再返回给客户端。<br>
 * 而且客户端可以不读那的进行文本转换，当客户端输入over时，转换结束。<br>
 * <p>
 * 分析：<br>
 * 客户端：<br>
 * 既然是操作数据，那么就可以使用IO技术，并按照IO的操作规律来思考。<br>
 * 源：键盘录入。<br>
 * 目的：网络设备，网络输出流。<br>
 * 而且操作的是文本数据，可以选择字符流。<br>
 * <br>
 * 步骤：<br>
 * 1.建立服务。<br>
 * 2.获取键盘录入。<br>
 * 3.将数据发给服务端。<br>
 * 4.获取服务端返回的大写数据。<br>
 * 5.结束，关闭源。<br>
 * <p>
 * 都是文本数据，可以使用字符流进行操作，同时提高效率，加入缓冲。<br>
 * <p>
 * 该例子出现的问题。<br>
 * 现象：客户端和服务端都在莫名的等待，为什么呢？<br>
 * 因为客户端和服务端都有阻塞式方法，这些方法没有读到结束标记，那么就一直等。<br>
 * 而导致两端，都在等待。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day23-13-网络编程(TCP练习)
 */
public class TransTextDemo {
	public static void main(String[] args) {

	}
}

class TcpClient3 {
	public static void main(String[] args) throws IOException {
		Socket s = new Socket("192.168.159.1", 10005);

		// 定义读取键盘数据的流对象。
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));

		// 定义目的，将数据写入到Socket输出流，发给服务端。
		// BufferedWriter bufOut = new BufferedWriter(new
		// OutputStreamWriter(s.getOutputStream()));
		PrintWriter out = new PrintWriter(s.getOutputStream(), true);

		// 定义一个Socket读取流，读取服务端返回的大写信息
		BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));

		String line = null;
		while ((line = bufr.readLine()) != null) {
			if ("over".equals(line)) {
				break;
			}

			out.println(line);
			// bufOut.write(line);
			// bufOut.newLine();
			// bufOut.flush();

			String str = bufIn.readLine();
			System.out.println("server:" + str);
		}

		bufr.close();
		s.close();
	}
}

class TcpServer3 {
	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(10005);

		Socket s = ss.accept();

		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip + "...connected");

		// 读取Socket读取流中的数据。
		BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));

		// 目的:Socket输出流。将大写数据写入到Socket输出流，并发送给客户端。
		// BufferedWriter bufOut = new BufferedWriter(new
		// OutputStreamWriter(s.getOutputStream()));
		PrintWriter out = new PrintWriter(s.getOutputStream(), true);

		String line = null;
		while ((line = bufIn.readLine()) != null) {
			System.out.println(line);

			out.println(line.toUpperCase());
			// bufOut.write(line.toUpperCase());
			// bufOut.newLine();
			// bufOut.flush();
		}

		s.close();
		ss.close();
	}
}