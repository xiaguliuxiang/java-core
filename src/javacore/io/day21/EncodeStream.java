package javacore.io.day21;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * IO流(转换流的字符编码)<br>
 * <p>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day21-06-IO流(转换流的字符编码)
 */
public class EncodeStream {

	public static void main(String[] args) throws IOException {
		writeText();
		readText();
	}

	public static void readText() throws IOException {
		InputStreamReader isr = new InputStreamReader(new FileInputStream("file" + File.separator + "EncodeStream.txt"),
				"UTF-8");

		char[] buf = new char[10];
		int len = isr.read(buf);

		String str = new String(buf, 0, len);

		System.out.println(str);

		isr.close();
	}

	public static void writeText() throws IOException {
		OutputStreamWriter osw = new OutputStreamWriter(
				new FileOutputStream("file" + File.separator + "EncodeStream.txt"), "UTF-8");

		osw.write("你好");

		osw.close();
	}
}
