package javacore.io.day20;

import java.io.File;
import java.io.FilenameFilter;

/**
 * IO流(File对象功能-文件列表)<br>
 * IO流(File对象功能-文件列表2)<br>
 * <p>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day20-05-IO流(File对象功能-文件列表)
 * @see 传智播客毕向东Java基础视频教程-day20-06-IO流(File对象功能-文件列表2)
 */
public class FileDemo2 {

	public static void main(String[] args) {
		listDemo_3();
	}

	public static void listDemo_3() {
		File dir = new File("file");
		File[] files = dir.listFiles();

		for (File file : files) {
			System.out.println(file.getName() + ":" + file.length());
		}
	}

	public static void listDemo_2() {
		File dir = new File("file");

		String[] arr = dir.list(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				System.out.println("dir:" + dir + ",name:" + name);
				if (name.endsWith(".java")) {
					return true;
				} else {
					return false;
				}
			}
		});

		System.out.println("len:" + arr.length);
		for (String name : arr) {
			System.out.println(name);
		}
	}

	public static void listDemo() {
		File file = new File("file");

		// 调用list()方法的file对象必须是封装了一个目录，该目录还必须存在。
		String[] names = file.list();

		for (String name : names) {
			System.out.println(name);
		}
	}

	public static void listRootsDemo() {
		File[] files = File.listRoots();

		for (File file : files) {
			System.out.println(file);
		}
	}

}
