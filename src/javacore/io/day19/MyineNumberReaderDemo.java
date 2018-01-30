package javacore.io.day19;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * IO流(MyineNumberReader)<br>
 * <p>
 * 模拟一个带行号的缓冲区对象。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day19-10-IO流(MyineNumberReader)
 */
public class MyineNumberReaderDemo {

	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("file" + File.separator + "src.txt");

		MyLineNumberReader mylnr = new MyLineNumberReader(fr);

		String line = null;

		while ((line = mylnr.myReadLine()) != null) {
			System.out.println(line);
		}

		mylnr.myClose();
	}
}

class MyLineNumberReader2 extends MyBufferedReader {
	private int lineNumber;

	public MyLineNumberReader2(FileReader r) {
		super(r);
	}

	@Override
	public String myReadLine() throws IOException {
		lineNumber++;
		return super.myReadLine();
	}

	public int getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}

}

class MyLineNumberReader {
	private Reader r;
	private int lineNumber;

	public MyLineNumberReader(Reader r) {
		super();
		this.r = r;
	}

	public String myReadLine() throws IOException {
		lineNumber++;
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
		return null;
	}

	public int getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}

	public void myClose() throws IOException {
		r.close();
	}
}