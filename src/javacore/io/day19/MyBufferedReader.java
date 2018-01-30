package javacore.io.day19;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * IO流(MyBufferedReader)<br>
 * <p>
 * 明白了BufferedReader类中特有方法readLine()的原理后，<br>
 * 可以自定义一个类中包含一个功能和readLine()一致的方法。<br>
 * 来模拟一下BufferedReader。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day19-05-IO流(MyBufferedReader)
 */
public class MyBufferedReader {

	private FileReader r;

	public MyBufferedReader(FileReader r) {
		super();
		this.r = r;
	}

	// 可以一次读一行数据的方法。
	public String myReadLine() throws IOException {
		// 定义了一个临时容器，原BufferedReader封装的是字符数组。
		// 为了演示方便，定义一个StringBuilder容器，因为最终还是要将数据变成字符串。
		StringBuilder sb = new StringBuilder();
		int ch = 0;
		while ((ch = r.read()) != -1) {
			if (ch == '\r') {
				continue;
			}
			if (ch == '\n') {
				return sb.toString();
			} else {
				sb.append((char) ch);
			}
		}
		if (sb.length() != 0) {
			return sb.toString();
		}
		return null;
	}

	public void myClose() throws IOException {
		r.close();
	}

	public static void main(String[] args) throws IOException {

		FileReader fr = new FileReader("file" + File.separator + "src.txt");

		MyBufferedReader myBuf = new MyBufferedReader(fr);

		String line = null;

		while ((line = myBuf.myReadLine()) != null) {
			System.out.println(line);
		}

		myBuf.myClose();

	}

}
