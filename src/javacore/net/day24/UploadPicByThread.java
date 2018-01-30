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
 * 网络编程(TCP-客户端并发上传图片)<br>
 * <p>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day24-02-网络编程(TCP-客户端并发上传图片)
 */
public class UploadPicByThread {
	public static void main(String[] args) {

	}
}

/**
 * 客户端<br>
 * <p>
 */
class PicClient2 {
	public static void main(String[] args) throws IOException {

		args = new String[1];
		args[0] = System.getProperty("user.dir") + File.separator + "file" + File.separator + "src.jpg";
		System.out.println(args[0]);

		if (args.length != 1) {
			System.out.println("请选择一个jpg格式的图片");
			return;
		}

		File file = new File(args[0]);
		if (!(file.exists() && file.isFile())) {
			System.out.println("该文件有问题，文件不存在或不是文件。");
			return;
		}

		if (!file.getName().endsWith(".jpg")) {
			System.out.println("图片格式错误，请重新选择。");
		}

		if (file.length() > 1024 * 1024 * 8) {
			System.out.println("文件过大，请重新选择。");
			return;
		}

		Socket s = new Socket("192.168.159.1", 10007);

		FileInputStream fis = new FileInputStream(file);

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
 * 服务端线程<br>
 * <p>
 */
class PicThread implements Runnable {
	private Socket s;

	PicThread(Socket s) {
		this.s = s;
	}

	@Override
	public void run() {
		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip + "...connected");

		int count = 1;

		try {
			InputStream in = s.getInputStream();

			File file = new File("file" + File.separator + ip + "(" + count + ").jpg");

			while (file.exists()) {
				file = new File("file" + File.separator + ip + "(" + (count++) + ").jpg");
			}

			FileOutputStream fos = new FileOutputStream(file);

			byte[] buf = new byte[1024];

			int len = 0;
			while ((len = in.read(buf)) != -1) {
				fos.write(buf, 0, len);
			}

			OutputStream out = s.getOutputStream();

			out.write("上传成功".getBytes());

			fos.close();

			s.close();
		} catch (Exception e) {
		}
	}
}

/**
 * 服务端<br>
 * <p>
 */
class PicServer2 {
	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(10007);

		while (true) {
			Socket s = ss.accept();

			new Thread(new PicThread(s)).start();

			if (s.getInetAddress().getHostName().isEmpty()) {
				ss.close();
			}
		}
	}
}