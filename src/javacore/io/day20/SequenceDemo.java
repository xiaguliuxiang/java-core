package javacore.io.day20;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

/**
 * IO流(合并流)<br>
 * <p>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day20-16-IO流(合并流)
 */
public class SequenceDemo {

	public static void main(String[] args) throws IOException {

		Vector<FileInputStream> v = new Vector<FileInputStream>();

		v.add(new FileInputStream("file" + File.separator + "info.txt"));
		v.add(new FileInputStream("file" + File.separator + "src.java"));
		v.add(new FileInputStream("file" + File.separator + "src.txt"));

		Enumeration<FileInputStream> en = v.elements();

		SequenceInputStream sis = new SequenceInputStream(en);

		FileOutputStream fos = new FileOutputStream("file" + File.separator + "SequenceDemo_dist.txt");

		byte[] buf = new byte[1024];

		int len = 0;
		while ((len = sis.read(buf)) != -1) {
			fos.write(buf, 0, len);
		}

		fos.close();
		sis.close();
	}

}
