package javacore.net.day24;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 网络编程(TCP-客户端并发登录)<br>
 * <p>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day24-03-网络编程(TCP-客户端并发登录)
 */
public class UserLogin {
	public static void main(String[] args) {

	}
}

class LoginClient {
	public static void main(String[] args) throws IOException {
		Socket s = new Socket("192.168.159.1", 10008);

		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));

		PrintWriter out = new PrintWriter(s.getOutputStream(), true);

		BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));

		for (int i = 0; i < 3; i++) {
			String line = bufr.readLine();
			if (line == null) {
				break;
			}
			out.println(line);

			String info = bufIn.readLine();
			System.out.println("info:" + info);
			if (info.contains("欢迎")) {
				break;
			}
		}

		bufr.close();
		s.close();
	}
}

class UserThread implements Runnable {
	private Socket s;

	UserThread(Socket s) {
		this.s = s;
	}

	@Override
	public void run() {
		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip + "...connected");
		try {
			for (int i = 0; i < 3; i++) {
				BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));

				String name = bufIn.readLine();

				BufferedReader bufr = new BufferedReader(new FileReader("file" + File.separator + "src.txt"));

				PrintWriter out = new PrintWriter(s.getOutputStream(), true);

				String line = null;

				boolean flag = false;
				while ((line = bufr.readLine()) != null) {
					if (line.equals(name)) {
						flag = true;
						break;
					}
				}

				if (flag) {
					System.out.println(name + "已登录");
					out.println(name + ",欢迎光临");
					break;
				} else {
					System.out.println(name + "尝试登录");
					out.println(name + "用户名不存在");
				}

				bufr.close();
			}
			s.close();
		} catch (Exception e) {
			throw new RuntimeException(ip + "校验失败");
		}
	}
}

class LoginServer {
	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(10008);

		while (true) {
			Socket s = ss.accept();

			new Thread(new UserThread(s)).start();

			if (s.getInetAddress().getHostName().isEmpty()) {
				ss.close();
			}
		}
	}
}