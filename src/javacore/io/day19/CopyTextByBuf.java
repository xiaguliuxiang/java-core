package javacore.io.day19;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * IO流(通过缓冲区复制文本文件)<br>
 * IO流(readLine的原理图例)<br>
 * <p>
 * 通过缓冲区复制一个.java文件。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day19-03-IO流(通过缓冲区复制文本文件)
 * @see 传智播客毕向东Java基础视频教程-day19-04-IO流(readLine的原理图例)
 */
public class CopyTextByBuf {

	public static void main(String[] args) {
		BufferedReader bufr = null;
		BufferedWriter bufw = null;

		try {
			bufr = new BufferedReader(new FileReader("file" + File.separator + "src.java"));
			bufw = new BufferedWriter(new FileWriter("file" + File.separator + "CopyTextByBuf_dist.java"));

			String line = null;

			while ((line = bufr.readLine()) != null) {
				bufw.write(line);
				bufw.newLine();
				bufw.flush();
			}

		} catch (IOException e) {
			throw new RuntimeException("读写失败!");
		} finally {
			try {
				if (bufr != null) {
					bufr.close();
				}
			} catch (IOException e) {
				throw new RuntimeException("读取关闭失败!");
			}
			try {
				if (bufw != null) {
					bufw.close();
				}
			} catch (IOException e) {
				throw new RuntimeException("写入关闭失败!");
			}
		}
	}
}
