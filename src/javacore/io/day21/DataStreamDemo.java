package javacore.io.day21;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * IO流(操作基本数据类型的流对象DataStream)<br>
 * <p>
 * DataInputStream和DataOutputStream<br>
 * 可以用于操作基本数据类型的数据的流对象。<br>
 * <p>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day21-04-IO流(操作基本数据类型的流对象DataStream)
 */
public class DataStreamDemo {

	public static void main(String[] args) throws IOException {
		// writeData();
		// readData();

		writeUTFData();
		readUTFData();

		// writeUTFData_2();
	}

	public static void writeUTFData_2() throws IOException {
		OutputStreamWriter osw = new OutputStreamWriter(
				new FileOutputStream("file" + File.separator + "DataStreamDemo_dist_utf_2.txt"), "UTF-8");

		osw.write("你好");

		osw.close();
	}

	public static void readUTFData() throws IOException {
		DataInputStream dis = new DataInputStream(
				new FileInputStream("file" + File.separator + "DataStreamDemo_dist_utf.txt"));

		String s = dis.readUTF();
		System.out.println(s);

		dis.close();
	}

	public static void writeUTFData() throws IOException {
		DataOutputStream dos = new DataOutputStream(
				new FileOutputStream("file" + File.separator + "DataStreamDemo_dist_utf.txt"));

		dos.writeUTF("你好");

		dos.close();
	}

	public static void readData() throws IOException {
		DataInputStream dis = new DataInputStream(
				new FileInputStream("file" + File.separator + "DataStreamDemo_dist.txt"));

		int num = dis.readInt();
		boolean b = dis.readBoolean();
		double d = dis.readDouble();

		System.out.println("num = " + num);
		System.out.println("b = " + b);
		System.out.println("d = " + d);

		dis.close();
	}

	public static void writeData() throws IOException {
		DataOutputStream dos = new DataOutputStream(
				new FileOutputStream("file" + File.separator + "DataStreamDemo_dist.txt"));

		dos.writeInt(234);
		dos.writeBoolean(true);
		dos.writeDouble(987.654);

		dos.close();
	}

}
