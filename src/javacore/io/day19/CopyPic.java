package javacore.io.day19;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * IO流(拷贝图片)<br>
 * <p>
 * 复制一个图片。<br>
 * 思路：<br>
 * 1、用字节读取流对象和图片关联。<br>
 * 2、用字节写入流对象创建一个图片文件，用于存储获取到的图片数据。<br>
 * 3、通过循环读写，完成数据的存储。<br>
 * 4、关闭资源。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day19-12-IO流(拷贝图片)
 */
public class CopyPic {

	public static void main(String[] args) {
		FileOutputStream fos = null;
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("file" + File.separator + "src.jpg");
			fos = new FileOutputStream("file" + File.separator + "CopyPic_dist.jpg");

			byte[] buf = new byte[1024];

			int len = 0;

			while ((len = fis.read(buf)) != -1) {
				fos.write(buf, 0, len);
			}
		} catch (IOException e) {
			throw new RuntimeException("复制文件失败!");
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
			} catch (IOException e) {
				throw new RuntimeException("读取关闭失败!");
			}
			try {
				if (fos != null) {
					fos.close();
				}
			} catch (IOException e) {
				throw new RuntimeException("写入关闭失败!");
			}
		}
	}

}
