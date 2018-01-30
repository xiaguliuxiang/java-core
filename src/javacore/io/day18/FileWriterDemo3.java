package javacore.io.day18;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * IO流(文件的续写)<br>
 * <p>
 * 演示对已有文件的数据续写。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day18-09-IO流(文件的续写)
 */
public class FileWriterDemo3 {

	public static void main(String[] args) throws IOException {

		// 传递一个true参数，代表不覆盖已有的文件，并在已有的文件末尾处进行数据续写。
		FileWriter fw = new FileWriter("file" + File.separator + "FileWriterDemo3_dist.txt", true);

		fw.write("FileWriterDemo3\r\nFileWriterDemo3");

		fw.close();

	}

}
