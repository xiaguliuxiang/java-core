package javacore.io.day21;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * IO流(RandomAccessFile)<br>
 * <p>
 * 该类不算是IO体系中的子类，而是直接继承自Object。<br>
 * 
 * 但是它是IO包中的成员。因为它具备读和写功能。<br>
 * 内部封装了一个数组，而且通过指针对数组的元素进行操作。<br>
 * 可以通过getFilePointer()获取指针位置。<br>
 * 同时可以通过seek()改变指针的位置。<br>
 * 
 * 其实完成读写的原理就是内部封装了字节输入流和输出流。<br>
 * 
 * 通过构造函数可以看出，该类只能操作文件。<br>
 * 而且操作文件还有模式：只读:r,读写:rw等。<br>
 * 
 * 如果模式为只读r,不会创建文件，会去读取一个已存在的文件，如果该文件不存在，则会出现异常。<br>
 * 如果模式为读写rw,操作的文件不存在，会自动创建，如果存在则不会覆盖。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day21-03-IO流(RandomAccessFile)
 */
public class RandomAccessFileDemo {

	public static void main(String[] args) throws IOException {
		// writeFile();
		// readFile();

		writeFile_2();
		readFile();

		// System.out.println(Integer.toBinaryString(258));

		RandomAccessFile raf = new RandomAccessFile("file" + File.separator + "RandomAccessFileDemo_dist.txt", "rw");
		raf.write("hahah".getBytes());
		raf.close();
	}

	public static void readFile() throws IOException {
		RandomAccessFile raf = new RandomAccessFile("file" + File.separator + "RandomAccessFileDemo_dist.txt", "r");

		// 调整对象中指针。
		// raf.seek(8 * 1);

		// 跳过指定的字节数
		// raf.skipBytes(8);

		byte[] buf = new byte[4];

		raf.read(buf);

		String name = new String(buf);

		int age = raf.readInt();

		System.out.println("name = " + name);
		System.out.println("age = " + age);

		raf.close();
	}

	public static void writeFile_2() throws IOException {
		RandomAccessFile raf = new RandomAccessFile("file" + File.separator + "RandomAccessFileDemo_dist.txt", "rw");
		raf.seek(8 * 0);
		raf.write("周期".getBytes());
		raf.writeInt(103);

		raf.close();
	}

	public static void writeFile() throws IOException {
		RandomAccessFile raf = new RandomAccessFile("file" + File.separator + "RandomAccessFileDemo_dist.txt", "rw");

		raf.write("李四".getBytes());
		raf.writeInt(97);
		raf.write("王五".getBytes());
		raf.writeInt(99);

		raf.close();
	}

}
