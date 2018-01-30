package javacore.io.day19;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * IO流(字节流的缓冲区)<br>
 * <p>
 * 演示mp3的赋值，通过缓冲区。<br>
 * BufferedOutputStream<br>
 * BufferedInputStream<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day19-13-IO流(字节流的缓冲区)
 */
public class CopyMP3 {

	public static void main(String[] args) throws IOException {
		long start = System.currentTimeMillis();
		copy_1();
		long end = System.currentTimeMillis();

		System.out.println((end - start) + "毫秒");
	}

	// 通过字节流的缓冲区完成复制。
	public static void copy_1() throws IOException {
		BufferedInputStream bufis = new BufferedInputStream(new FileInputStream("file" + File.separator + "src.mp3"));
		BufferedOutputStream bufos = new BufferedOutputStream(
				new FileOutputStream("file" + File.separator + "CopyMP3_dist.mp3"));

		int by = 0;

		while ((by = bufis.read()) != -1) {
			bufos.write(by);
		}

		bufos.close();
		bufis.close();
	}

}
