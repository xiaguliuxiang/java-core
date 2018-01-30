package javacore.io.day20;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;

/**
 * IO流(切割文件)<br>
 * <p>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day20-17-IO流(切割文件)
 */
public class SplitFile {

	public static void main(String[] args) throws IOException {
		splitFile();
		merge();
	}

	public static void merge() throws IOException {
		ArrayList<FileInputStream> al = new ArrayList<FileInputStream>();

		for (int i = 1; i < 2; i++) {
			al.add(new FileInputStream("file" + File.separator + "split" + i + ".jpg.dist.part"));
		}

		final Iterator<FileInputStream> it = al.iterator();

		Enumeration<FileInputStream> en = new Enumeration<FileInputStream>() {
			@Override
			public boolean hasMoreElements() {
				return it.hasNext();
			}

			@Override
			public FileInputStream nextElement() {
				return it.next();
			}
		};

		SequenceInputStream sis = new SequenceInputStream(en);

		FileOutputStream fos = new FileOutputStream("file" + File.separator + "merge_dist.jpg");

		byte[] buf = new byte[128];

		int len = 0;

		while ((len = sis.read(buf)) != -1) {
			fos.write(buf, 0, len);
		}

		fos.close();
		sis.close();
	}

	public static void splitFile() throws IOException {
		FileInputStream fis = new FileInputStream("file" + File.separator + "src.jpg");

		FileOutputStream fos = null;

		byte[] buf = new byte[1024 * 128];

		int len = 0;
		int count = 1;
		while ((len = fis.read(buf)) != -1) {
			fos = new FileOutputStream("file" + File.separator + "split" + (count++) + ".jpg.dist.part");
			fos.write(buf, 0, len);
			fos.close();
		}
		fis.close();
	}

}
