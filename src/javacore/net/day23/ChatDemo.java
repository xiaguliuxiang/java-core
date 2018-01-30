package javacore.net.day23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 网络编程(UDP-聊天)<br>
 * <p>
 * 编写一个聊天程序。<br>
 * 有收数据的部分，和发数据的部分。<br>
 * 这两部分需要同时执行。<br>
 * 那就需要用到多线程技术。<br>
 * 一个线程控制收，一个线程控制发。<br>
 * <p>
 * 因为收和发的动作是不一致的，所以要定义两个run()方法。<br>
 * 而且这两个方法要封装到不同的类中。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day23-10-网络编程(UDP-聊天)
 */
public class ChatDemo {
	public static void main(String[] args) throws IOException {
		DatagramSocket sendSocket = new DatagramSocket();
		DatagramSocket receSocket = new DatagramSocket(10002);

		new Thread(new Send(sendSocket)).start();
		new Thread(new Rece(receSocket)).start();
	}
}

class Send implements Runnable {
	private DatagramSocket ds;

	Send(DatagramSocket ds) {
		this.ds = ds;
	}

	@Override
	public void run() {
		try {
			BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
			String line = null;
			while ((line = bufr.readLine()) != null) {
				if ("886".equals(line)) {
					break;
				}
				byte[] buf = line.getBytes();
				DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("192.158.159.1"), 10002);
				ds.send(dp);
			}
		} catch (Exception e) {
			throw new RuntimeException("发送端失败");
		}
	}
}

class Rece implements Runnable {
	private DatagramSocket ds;

	Rece(DatagramSocket ds) {
		this.ds = ds;
	}

	@Override
	public void run() {
		while (true) {
			byte[] buf = new byte[1024];
			DatagramPacket dp = new DatagramPacket(buf, buf.length);
			try {
				ds.receive(dp);
				String ip = dp.getAddress().getHostAddress();
				String data = new String(dp.getData(), 0, dp.getLength());
				System.out.println(ip + "::" + data);
			} catch (IOException e) {
				throw new RuntimeException("接收端失败");
			}
		}
	}
}