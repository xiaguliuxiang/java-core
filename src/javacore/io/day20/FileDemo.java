package javacore.io.day20;

import java.io.File;
import java.io.IOException;

/**
 * IO流(File概述)<br>
 * IO流(File对象功能-创建和删除)<br>
 * IO流(File对象功能-判断)<br>
 * IO流(File对象功能-获取)<br>
 * <p>
 * File类常见方法<br>
 * 创建、删除、判断、获取信息。<br>
 * <p>
 * 
 * <pre>
 * <b>1、创建。</b>
 *     boolean createNewFile();
 *         在指定位置创建文件，如果该文件已经存在，则不创建，返回false。
 *         和输出流不一样，输出流对象一样创建新文件，而且文件已经存在时会覆盖原文件。
 * 
 * <b>2、删除。</b>
 *     boolean delete();
 *         删除失败返回false。
 *     void deleteOnExit();
 *         在程序退出时删除指定文件。
 * 
 * <b>3、判断。</b>
 *     boolean exists();文件是否存在。
 *     isFile();
 *     isDirectory();
 *     isHidden();
 *     isAbsolute();
 * 
 * <b>4、获取信息。</b>
 *     getName();
 *     getPath();
 *     getParent();
 *     getAbsolutePath();
 *     long lastModified();
 *     long length();
 * </pre>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day20-01-IO流(File概述)
 * @see 传智播客毕向东Java基础视频教程-day20-02-IO流(File对象功能-创建和删除)
 * @see 传智播客毕向东Java基础视频教程-day20-03-IO流(File对象功能-判断)
 * @see 传智播客毕向东Java基础视频教程-day20-04-IO流(File对象功能-获取)
 */
public class FileDemo {

	public static void main(String[] args) throws IOException {
		method_5();
	}

	public static void method_5() {
		File file1 = new File("file" + File.separator + "FileDemo_file1.txt");
		File file2 = new File("file" + File.separator + "FileDemo_file2.txt");

		sop("rename:" + file1.renameTo(file2));
	}

	public static void method_4() {
		File file = new File("file" + File.separator + "FileDemo_file.txt");

		sop("path:" + file.getPath());
		sop("abspath:" + file.getAbsolutePath());
		// 该方法返回的是绝对路径中的父目录,如果获取的是相对路径,返回null.
		// 如果相对路径中有上一层目录,那么该目录就是返回结果.
		sop("parent:" + file.getParent());
		sop("lastModified:" + file.lastModified());
	}

	/**
	 * 文件是否是目录,是否是隐藏文件。
	 * 
	 * @throws IOException
	 */
	public static void method_3() throws IOException {
		File file = new File("file" + File.separator + "FileDemo_file.txt");

		// file.createNewFile();
		file.mkdir();

		// 记住在判断文件对象是否是文件或者目的时，必须要先判断该文件对象封装的内容是否存在。
		// 通过exists()判断。
		sop("dir:" + file.isDirectory());
		sop("file:" + file.isFile());

		sop("absolute:" + file.isAbsolute());
		sop("hidden:" + file.isHidden());

		file.delete();
	}

	/**
	 * 文件是否存在,是否可执行
	 * 
	 * @throws IOException
	 */
	public static void method_2() throws IOException {
		File file = new File("file" + File.separator + "src.java");

		sop("exists:" + file.exists());

		sop("execute:" + file.canExecute());

		// 创建文件夹
		File dir = new File("file" + File.separator + "FileDemo_test");
		sop("mkdir:" + dir.mkdirs());
	}

	/**
	 * 创建,删除
	 * 
	 * @throws IOException
	 */
	public static void method_1() throws IOException {
		File file = new File("file" + File.separator + "FileDemo_file.txt");

		sop("create:" + file.createNewFile());
		sop("delete:" + file.delete());
	}

	/**
	 * 创建File对象
	 */
	public static void consMethod() {
		// 将src.txt封装成file对象，可以将已有的和未出现的文件或者文件夹封装成对象。
		File file1 = new File("file" + File.separator + "FileDemo_file1.txt");

		File file2 = new File("file", "FileDemo_file2.txt");

		File dic = new File("file");
		File file3 = new File(dic, "FileDemo_file3.txt");

		sop("file1:" + file1);
		sop("file2:" + file2);
		sop("file3:" + file3);

		File file4 = new File("file" + File.separator + "FileDemo_file4.txt");

		sop("file4:" + file4);
	}

	public static void sop(Object obj) {
		System.out.println(obj);
	}

}
