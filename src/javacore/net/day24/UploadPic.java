package javacore.net.day24;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 网络编程(TCP-上传图片)<br>
 * <p>
 * 需求：上传图片。
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day24-01-网络编程(TCP-上传图片)
 */
public class UploadPic {
	public static void main(String[] args) {

	}
}

/**
 * 客户端。<br>
 * <p>
 * 1.服务端点。<br>
 * 2.读取客户端已有的图片数据。<br>
 * 3.通过Socket输出流将数据发给服务端。<br>
 * 4.读取服务端反馈信息。<br>
 * 5.关闭。
 */
class PicClient {
	public static void main(String[] args) throws IOException {
		Socket s = new Socket("192.168.159.1", 10007);

		FileInputStream fis = new FileInputStream("file" + File.separator + "src.jpg");

		OutputStream out = s.getOutputStream();

		byte[] buf = new byte[1024];

		int len = 0;

		while ((len = fis.read(buf)) != -1) {
			out.write(buf, 0, len);
		}

		// 告诉服务端数据已写完
		s.shutdownOutput();

		InputStream in = s.getInputStream();

		byte[] bufIn = new byte[1024];

		int num = in.read(bufIn);
		System.out.println(new String(bufIn, 0, num));

		fis.close();
		s.close();
	}
}

/**
 * 服务端。<br>
 */
class PicServer {
	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(10007);

		Socket s = ss.accept();

		InputStream in = s.getInputStream();

		FileOutputStream fos = new FileOutputStream("file" + File.separator + "dist.jpg");

		byte[] buf = new byte[1024];

		int len = 0;
		while ((len = in.read(buf)) != -1) {
			fos.write(buf, 0, len);
		}

		OutputStream out = s.getOutputStream();

		out.write("上传成功".getBytes());

		fos.close();

		s.close();

		ss.close();
	}
}