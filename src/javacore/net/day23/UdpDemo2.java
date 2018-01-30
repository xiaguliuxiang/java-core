package javacore.net.day23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 网络编程(UDP-键盘录入方式数据)<br>
 * <p>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day23-09-网络编程(UDP-键盘录入方式数据)
 */
public class UdpDemo2 {
	public static void main(String[] args) {

	}
}

class UdpSend2 {
	public static void main(String[] args) throws IOException {
		DatagramSocket ds = new DatagramSocket();
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		while ((line = bufr.readLine()) != null) {
			if ("886".equals(line)) {
				break;
			}
			byte[] buf = line.getBytes();
			DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("192.168.159.1"), 10001);
			ds.send(dp);
		}
		ds.close();
	}
}

class UdpRece2 {
	public static void main(String[] args) throws IOException {
		DatagramSocket ds = new DatagramSocket(10001);
		while (true) {
			byte[] buf = new byte[1024];
			DatagramPacket dp = new DatagramPacket(buf, buf.length);
			ds.receive(dp);
			String ip = dp.getAddress().getHostAddress();
			String data = new String(dp.getData(), 0, dp.getLength());
			System.out.println(ip + "::" + data);
			if (data.equals("over")) {
				ds.close();
			}
		}
	}
}
