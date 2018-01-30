package javacore.io.day19;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

/**
 * IO流(LineNumberReader)<br>
 * <p>
 * 练习：<br>
 * 模拟一个带行号的缓冲区对象。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day19-09-IO流(LineNumberReader)
 */
public class LineNumberReaderDemo {

	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("file" + File.separator + "src.txt");

		LineNumberReader lnr = new LineNumberReader(fr);

		String line = null;
		lnr.setLineNumber(100);
		while ((line = lnr.readLine()) != null) {
			System.out.println(lnr.getLineNumber() + ":" + line);
		}

		lnr.close();
	}

}
