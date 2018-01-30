package javacore.net.day23;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 网络编程(概述)<br>
 * 网络编程(概述2)<br>
 * 网络编程(网络模型)<br>
 * 网络编程(IP地址)<br>
 * <p>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day23-01-网络编程(概述)
 * @see 传智播客毕向东Java基础视频教程-day23-02-网络编程(概述2)
 * @see 传智播客毕向东Java基础视频教程-day23-03-网络编程(网络模型)
 * @see 传智播客毕向东Java基础视频教程-day23-04-网络编程(IP地址)
 */
public class IPDemo {
	public static void main(String[] args) throws UnknownHostException {
		InetAddress i = InetAddress.getLocalHost();

		System.out.println(i.toString());
		System.out.println("host:" + i.getHostAddress());
		System.out.println("hostName:" + i.getHostName());

		InetAddress ia = InetAddress.getByName("192.168.159.130");

		System.out.println(ia.toString());
		System.out.println("host:" + ia.getHostAddress());
		System.out.println("hostName:" + ia.getHostName());

	}
}
