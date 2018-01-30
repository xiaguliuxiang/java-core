package javacore.io.day20;

import java.io.File;

/**
 * IO流(删除带内容的目录)<br>
 * <p>
 * 删除一个带内容的目录。<br>
 * 删除原理：<br>
 * 在Windows中，删除目录从里面往外删除的。<br>
 * 既然是从里往外删除，就需要用到递归。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day20-09-IO流(删除带内容的目录)
 */
public class RemoveDir {

	public static void main(String[] args) {
		File dir = new File("file" + File.separator + "removeDir");
		removeDir(dir);
	}

	public static void removeDir(File dir) {
		if (dir.exists()) {
			File[] files = dir.listFiles();

			for (int i = 0; i < files.length; i++) {
				if (!files[i].isHidden() && files[i].isDirectory()) {
					removeDir(files[i]);
				} else {
					System.out.println(files[i].toString() + ":file:" + files[i].delete());
				}
			}

			System.out.println(dir + ":dir:" + dir.delete());
		} else {
			System.out.println(dir.getAbsolutePath() + ":不存在");
		}
	}

}
