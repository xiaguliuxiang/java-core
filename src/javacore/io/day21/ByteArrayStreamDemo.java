package javacore.io.day21;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * IO流(ByteArrayStream)<br>
 * <p>
 * ByteArrayStream<br>
 * 用于操作字节数组的流对象。<br>
 * <p>
 * ByteArrayInputStream:在构造的时候，需要接收数据源，而且数据源是一个字节数组。<br>
 * ByteArrayOutputStream:在构造的时候，不用定义数据目的，因为该对象中已经内部封装了可变长度的字节数组，<br>
 * 这就是数据目的地。<br>
 * 
 * 因为这两个流对象都操作的是数组，并没有使用系统资源。<br>
 * 所以，不用进行close()关闭。<br>
 * 
 * 在流操作规律讲解时：<br>
 * 源设备：<br>
 * |--键盘 System.in, 硬盘 FileStream, 内存 ArrayStream.<br>
 * 目的设备：<br>
 * |--控制台 System.out, 硬盘 FileStream, 内存 ArrayStream.<br>
 * 
 * 用流的读写思想来操作数据。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day21-05-IO流(ByteArrayStream)
 */
public class ByteArrayStreamDemo {

	public static void main(String[] args) throws IOException {
		// 数据源。
		ByteArrayInputStream bis = new ByteArrayInputStream("ABCDEFG".getBytes());

		// 数据目的。
		ByteArrayOutputStream bos = new ByteArrayOutputStream();

		int by = 0;

		while ((by = bis.read()) != -1) {
			bos.write(by);
		}

		System.out.println(bos.size());
		System.out.println(bos.toString());

		bos.writeTo(new FileOutputStream("file" + File.separator + "ByteArrayStreamDemo_dist.txt"));
	}

}
