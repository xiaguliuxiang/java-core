package javacore.io.day19;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

/**
 * IO流(流操作规律-1)<br>
 * IO流(流操作规律-2)<br>
 * IO流(改变标准输入输出设备)<br>
 * <p>
 * 1、需求：想把键盘录入的数据打印在控制台上。<br>
 * <tt>源：键盘录入。</tt><br>
 * <tt>目的：控制台。</tt><br>
 * <br>
 * 2、需求：想把键盘录入的数据存储到一个文件中。<br>
 * <tt>源：键盘。</tt><br>
 * <tt>目的：文件。</tt><br>
 * <br>
 * 3、需求：想要将一个文件的数据打印在控制台上。<br>
 * <tt>源：文件。</tt><br>
 * <tt>目的：控制台。</tt><br>
 * <br>
 * 流对象的基本规律。<br>
 * <tt>最痛苦的就是流对象有很多，不知道该用哪一个。</tt><br>
 * <tt>通过两个明确来完成。</tt><br>
 * 
 * <pre>
 * <b>1、明确源和目的。</b>
 *     源：输入流。InputStream,Reader.
 *     目的：输出流。OutputStream,Writer.
 * <b>2、操作的数据是否是纯文本。</b>
 *     是：字符流。
 *     不是：字节流。
 * <b>3、当体系明确后，再明确要使用哪个具体的对象。</b>
 *     通过设备来进行区分。
 *         源设备：内存，硬盘，键盘。
 *     目的设备：内存，硬盘，控制台。
 * </pre>
 * 
 * <pre>
 * <b>1、将一个文本文件中的数据存储到另一个文件中，也就是复制文件。</b>
 *     源：因为是源，所以使用读取流，InputStream,Reader.
 *         是不是操作文本文件?
 *             是!这样就可以选择Reader。
 *             这样体系就明确了。
 *         接下来明确要使用该体系中的哪个对象。
 *             明确设备：硬盘上个一个文件。
 *             Reader体系中可以操作文件的对象是：FileReader。
 *         是否需要提高效率?
 *             是，加入Reader体系中缓冲区bufferedReader。
 * 
 * 		FileReader fr = new FileReader("src.txt");
 * 		BufferedReader bufr = new BufferedReader(fr);
 * </pre>
 * 
 * <pre>
 *     目的：OutputStream,Writer。
 *         是否是纯文本?
 *             是!Writer.
 *         接下来明确要使用该体系中的哪个对象。
 *             设备：硬盘上个一个文件。
 *             Writer体系中可以操作文件的对象FileWriter。
 *         是否需要提高效率?
 *             是，加入Writer体系中缓冲区bufferedWriter。
 *             
 * 		FileWriter fw = new FileWriter("dist.txt");
 * 		BufferedWriter bufr = new BufferedWriter(fw);
 * </pre>
 * 
 * 练习：将一个图片中的数据存储到另一个文件中。<br>
 * 复制文件，要按照以上格式自己完成三个明确。<br>
 * 思路：使用字节流，使用字节流缓冲区。<br>
 * 
 * ----------------------------------------<br>
 * 
 * <pre>
 * <b>2、需求：将键盘录入的数据保存到一个文件中。</b>
 *     这个需求中源和目的都存在。
 *     那么分别分析。
 *         源：InputStream,Reader.
 *             是不是纯文本?
 *                 是!Reader.
 *             设备：键盘。对应的对象是System.in.
 *                 不是选择Reader吗?System.in对应的不是字节流吗?
 *                 为了操作键盘的文本数据方便，转成字符流按照字符串操作时最方便的。
 *                 所以既然明确了Reader，那么就将System.in转换成Reader.
 *                 用了Reader体系中的转换流，InputStreamReader.
 *             需要提高效率吗?
 *             需要!BufferedReader.
 * 		InputStreamReader isr = new InputStreamReader(System.in);
 * 		BufferedReader bufr= new BufferedReader(isr);
 * </pre>
 * 
 * <pre>
 *         目的：OutputStream,Writer.
 *             是不是纯文本?
 *                 是!Writer.
 *             设备：硬盘上的一个文件。
 *                 使用FileWriter.
 *             需要提高效率吗?
 *             需要!BufferedWriter.
 * 		FileWriter fw = new FileWriter("dist.txt");
 * 		BufferedWriter bufw= new BufferedWriter(fw);
 * </pre>
 * 
 * ----------------------------------------<br>
 * 
 * <pre>
 * <b>扩展一下，想要把录入的数据按照指定的编码表(UTF-8或GBK)，将数据存到文件中。</b>
 *     目的：OutputStream,Writer.
 *         是否是纯文本?
 *             是!Writer.
 *         设备?
 *             硬盘上的一个文件,使用FileWriter.
 *                 但是FileWriter使用的是默认的编码表,GBK.
 *     但是存储时，需要加入指定编码表utf-8,而指定编码表只有转换流可以指定。
 *     所以要使用的对象是OutputStreamWriter.
 *         而该转换流对象要接收一个字节输出流，而且还可以操作的文件的字节输出流。FileOutputStream.
 *     需要高效吗?
 *         需要，使用BufferedWriter。
 * 		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("dist.txt"), "UTF-8");
 * 		BufferedWriter bufw= new BufferedWriter(osw);
 * </pre>
 * 
 * 所以，记住，转换流什么时候使用。<br>
 * 字符和字节之间的桥梁，通常涉及到字符编码转换时，需要用到转换流。<br>
 * 
 * 练习：将一个文本数据打印在控制台上，要按照以上格式自己完成三个明确。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day19-18-IO流(流操作规律-1)
 * @see 传智播客毕向东Java基础视频教程-day19-19-IO流(流操作规律-2)
 * @see 传智播客毕向东Java基础视频教程-day19-20-IO流(改变标准输入输出设备)
 */
public class TransStreamDemo2 {

	public static void main(String[] args) throws IOException {
		// TransStreamDemo2_1();
		// TransStreamDemo2_2();
		TransStreamDemo2_3();
	}

	// 把键盘录入的数据存储到一个文件中
	public static void TransStreamDemo2_1() throws IOException {
		// 读取键盘录入的最常见写法
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));

		BufferedWriter bufw = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream("file" + File.separator + "TransStreamDemo2_dist.txt")));

		String line = null;

		while ((line = bufr.readLine()) != null) {
			if ("over".equals(line)) {
				break;
			}
			bufw.write(line.toUpperCase());
			bufw.newLine();
			bufw.flush();
		}
		bufr.close();
		bufw.close();
	}

	// 将一个文件的数据打印在控制台上
	public static void TransStreamDemo2_2() throws IOException {
		// 读取键盘录入的最常见写法
		BufferedReader bufr = new BufferedReader(
				new InputStreamReader(new FileInputStream("file" + File.separator + "TransStreamDemo2_dist.txt")));

		BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(System.out));

		String line = null;

		while ((line = bufr.readLine()) != null) {
			if ("over".equals(line)) {
				break;
			}
			bufw.write(line.toUpperCase());
			bufw.newLine();
			bufw.flush();
		}
		bufr.close();
	}

	// 转换流设置文件编码
	public static void TransStreamDemo2_3() throws IOException {
		// 读取键盘录入的最常见写法
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));

		BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream("file" + File.separator + "TransStreamDemo2_3_dist.txt"), "UTF-8"));

		String line = null;

		while ((line = bufr.readLine()) != null) {
			if ("over".equals(line)) {
				break;
			}
			bufw.write(line.toUpperCase());
			bufw.newLine();
			bufw.flush();
		}
		bufr.close();
		bufw.close();
	}

	// 练习：将一个文本数据打印在控制台上，要按照以上格式自己完成三个明确。
	public static void TransStreamDemo2_4() throws IOException {

		// 修改源和目的都是文件的话，就是文件复制了。
		System.setIn(new FileInputStream("file" + File.separator + "TransStreamDemo2_dist.txt"));
		System.setOut(new PrintStream("file" + File.separator + "TransStreamDemo2_dist.txt"));

		// 读取键盘录入的最常见写法
		BufferedReader bufr = new BufferedReader(
				new InputStreamReader(new FileInputStream("file" + File.separator + "TransStreamDemo2_dist.txt")));

		BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(System.out));

		String line = null;

		while ((line = bufr.readLine()) != null) {
			if ("over".equals(line)) {
				break;
			}
			bufw.write(line.toUpperCase());
			bufw.newLine();
			bufw.flush();
		}
		bufr.close();
	}

}
