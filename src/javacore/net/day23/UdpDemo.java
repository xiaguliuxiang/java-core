package javacore.net.day23;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 网络编程(TCP和UDP)<br>
 * 网络编程(Socket)<br>
 * 网络编程(Udp-发送端)<br>
 * 网络编程(Udp-接收端)<br>
 * 网络编程(UDP-键盘录入方式数据)<br>
 * <p>
 * <p>
 * 网络通讯要素：
 * <ul>
 * <li>IP地址:InetAddress</li>
 * <dd>网络中设备的标识</dd>
 * <dd>不易记忆，可用主机名</dd>
 * <dd>本地回环地址:127.0.0.1主机名:localhost</dd>
 * <li>端口号</li>
 * <dd>用于标识进程的逻辑地址，不同进程的标识</dd>
 * <dd>有效端口:0~65535,其中0~1024系统使用或保留端口</dd>
 * <li>传输协议</li>
 * <dd>通讯的规则</dd>
 * <dd>常见协议:TCP,UDP</dd>
 * </ul>
 * <p>
 * TCP和UDP
 * <ul>
 * <li>UDP</li>
 * <dd>将数据及源和目的封装成数据包中，不需要建立连接</dd>
 * <dd>每个数据包的大小限制在64k内</dd>
 * <dd>因无连接，是不可靠协议</dd>
 * <dd>不需要建立连接，速度快</dd>
 * <li>TCP</li>
 * <dd>建立连接，形成传输数据的通道</dd>
 * <dd>在连接中进行大数据量传输</dd>
 * <dd>通过三次握手完成连接，是可靠协议</dd>
 * <dd>必须建立连接，效率会稍低</dd>
 * </ul>
 * <p>
 * Socket
 * <ul>
 * <li>Socket就是为网络服务提供的一种机制</li>
 * <li>通信的两端都有Socket</li>
 * <li>网络通信其实就是Socket间的通信</li>
 * <li>数据在两个Socket间通过IO传输</li>
 * </ul>
 * <p>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day23-05-网络编程(TCP和UDP)
 * @see 传智播客毕向东Java基础视频教程-day23-06-网络编程(Socket)
 * @see 传智播客毕向东Java基础视频教程-day23-07-网络编程(Udp-发送端)
 * @see 传智播客毕向东Java基础视频教程-day23-08-网络编程(Udp-接收端)
 * @see 传智播客毕向东Java基础视频教程-day23-09-网络编程(UDP-键盘录入方式数据)
 */
public class UdpDemo {
	public static void main(String[] args) {

	}
}

/**
 * 需求:通过UDP传输方式，将一段文字数据发送出去。<br>
 * 定义一个udp的发送端。<br>
 * <p>
 * 思路:<br>
 * 1.建立udpsocket服务。<br>
 * 2.提供数据，并将数据封装到数据包中。<br>
 * 3.通过socket服务的发送功能，将数据包发出去。<br>
 * 4.关闭资源。<br>
 */
class UdpSend {
	public static void main(String[] args) throws IOException {
		// 1.创建udp服务，通过DatagramSocket对象。
		DatagramSocket ds = new DatagramSocket(8888);

		// 2.确定数据，并封装成数据包。
		// DatagramPacket(byte buf[], int length, InetAddress address, int
		// port);
		byte[] buf = "udp is coming".getBytes();
		DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("192.168.159.1"), 10000);

		// 3.通过socket服务，将已有的数据包发送出去，通过send()方法。
		ds.send(dp);

		// 4.关闭资源。
		ds.close();
	}
}

/**
 * 需求:<br>
 * 定义一个应用程序，用于接收udp协议传输的数据并处理。<br>
 * 定义udp的接收端。<br>
 * <p>
 * 思路:<br>
 * 1.定义udpsocket服务。通常会监听一个端口，其实就是给这个接收网络应用程序定义数字标识。<br>
 * 方便与明确哪些数据过来该应用可以处理。<br>
 * 2.定义一个数据包，因为要存储接收到的字节数据。<br>
 * 因为数据包对象中有更多功能可以提取字节数据中的不同数据信息。<br>
 * 3.通过socket服务的receive()方法将受到的数据存入已定义好的数据包中。<br>
 * 4.通过数据包对象的特有功能，将这些不同的数据取出，打印在控制台上。<br>
 * 5.关闭资源。<br>
 */
class UdpRece {
	public static void main(String[] args) throws IOException {
		// 1.创建udp socket, 建立端点.
		DatagramSocket ds = new DatagramSocket(10000);

		while (true) {
			// 2.定义数据包，用于存储数据。
			byte[] buf = new byte[1024];
			DatagramPacket dp = new DatagramPacket(buf, buf.length);

			// 3.通过服务的receive()方法将收到的数据存入到数据包中。
			ds.receive(dp); // 阻塞式方法

			// 4.通过数据包的方法获取其中的数据。
			String ip = dp.getAddress().getHostAddress();
			String data = new String(dp.getData(), 0, dp.getLength());
			int port = dp.getPort();
			System.out.println(ip + "::" + data + "::" + port);

			// 5.关闭资源。
			// ds.close();
			if (data.equals("over")) {
				ds.close();
			}
		}
	}
}