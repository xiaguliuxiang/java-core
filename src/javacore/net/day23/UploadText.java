package javacore.net.day23;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 网络编程(TCP复制文件)<br>
 * <p>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day23-14-网络编程(TCP复制文件)
 */
public class UploadText {
	public static void main(String[] args) {

	}
}

class TextClient {
	public static void main(String[] args) throws IOException {
		Socket s = new Socket("192.168.159.1", 10006);

		BufferedReader bufr = new BufferedReader(new FileReader("file" + File.separator + "src.java"));

		PrintWriter out = new PrintWriter(s.getOutputStream(), true);

		String line = null;
		while ((line = bufr.readLine()) != null) {
			out.println(line);
		}

		// 关闭客户端的输出流，相当于给流中加入一个结束标记-1。
		s.shutdownOutput();

		BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));

		String str = bufIn.readLine();
		System.out.println(str);

		bufr.close();

		s.close();
	}
}

class TextServer {
	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(10006);

		Socket s = ss.accept();
		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip + "...connected");

		BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));

		PrintWriter out = new PrintWriter(new FileWriter("file" + File.separator + "UploadText_dist.java"), true);

		String line = null;
		while ((line = bufIn.readLine()) != null) {
			out.println(line);
		}

		PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
		pw.println("上传成功");

		out.close();
		s.close();
		ss.close();

	}
}