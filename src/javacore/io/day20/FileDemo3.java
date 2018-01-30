package javacore.io.day20;

import java.io.File;

/**
 * IO流(列出目录下所有内容-递归)<br>
 * IO流(列出目录下所有内容-带层次)<br>
 * <p>
 * 列出目录下所有内容<br>
 * 列出指定目录下文件或者文件夹，包含子目录的内容。<br>
 * 也就是列出指定目录下的内容。<br>
 * <p>
 * 因为目录中还有目录，只要使用同一个列出目录功能的函数完成即可。<br>
 * 在列出过程中出现的还是目录的话，还可以再次调用本功能。<br>
 * 也就是函数自身调用自身。<br>
 * 这种表现形式，或者编程手法，称为递归。<br>
 * 
 * 递归要注意：<br>
 * 1、限定条件。<br>
 * 2、要注意递归的次数，尽量避免内存溢出。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day20-07-IO流(列出目录下所有内容-递归)
 * @see 传智播客毕向东Java基础视频教程-day20-08-IO流(列出目录下所有内容-带层次)
 */
public class FileDemo3 {

	public static void main(String[] args) {
		File file = new File("file");
		showDir(file, 0);

		// toBin(6);

		// int n = getSum(3);
		// System.out.println("n = " + n);
	}

	public static int getSum(int n) {
		if (n == 1) {
			return 1;
		}
		return n + getSum(n - 1);
	}

	public static void toBin(int num) {
		if (num > 0) {
			toBin(num / 2);
			System.out.println(num % 2);
		}
	}

	public static String getLevel(int level) {
		StringBuilder sb = new StringBuilder();
		sb.append("|--");
		for (int i = 0; i < level; i++) {
			// sb.append("|--");
			sb.insert(0, "|  ");
		}
		return sb.toString();
	}

	public static void showDir(File dir, int level) {
		System.out.println(getLevel(level) + dir.getName());

		level++;
		File[] files = dir.listFiles();
		for (int i = 0; i < files.length; i++) {
			if (files[i].isDirectory()) {
				showDir(files[i], level);
			} else {
				System.out.println(getLevel(level) + files[i]);
			}
		}
	}
}
