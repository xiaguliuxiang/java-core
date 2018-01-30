package javacore.io.day20;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

/**
 * IO流(Properties简述)<br>
 * IO流(Properties存取)<br>
 * IO流(Properties存取配置文件)<br>
 * <p>
 * Properties是HashTable的子类。<br>
 * 也就是说它具备map集合的特点，而且它里面存储的键值对都是字符串。<br>
 * <p>
 * Properties是集合中和IO技术相结合的集合容器。<br>
 * 
 * 该对象的特点：可以用于键值对形式的配置文件。<br>
 * 
 * 在加载数据时，需要数据有固定的格式：键=值。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day20-11-IO流(Properties简述)
 * @see 传智播客毕向东Java基础视频教程-day20-12-IO流(Properties存取)
 * @see 传智播客毕向东Java基础视频教程-day20-13-IO流(Properties存取配置文件)
 */
public class PropertiesDemo {

	public static void main(String[] args) throws IOException {
		loadDemo();
	}

	public static void loadDemo() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("file" + File.separator + "info.txt");
		prop.load(fis);

		prop.setProperty("wangwu", "55");

		FileOutputStream fos = new FileOutputStream("file" + File.separator + "PropertiesDemo_info_dist.txt");

		prop.store(fos, "哈哈");

		// System.out.println(prop);
		prop.list(System.out);

		fos.close();
		fis.close();
	}

	/**
	 * 演示，如何将流中的数据存储到集合中。<br>
	 * 想要将info.txt中键值对数据存到集合中进行操作。<br>
	 * 1、用一个流和info.txt文件关联。<br>
	 * 2、读取一行数据，将该行数据用"="进行切割。<br>
	 * 3、等号左边作为键，右边作为值。存入到Properties集合中即可。<br>
	 * 
	 * @throws IOException
	 */
	public static void method_1() throws IOException {
		BufferedReader bufr = new BufferedReader(new FileReader("file" + File.separator + "info.txt"));
		String line = null;
		Properties prop = new Properties();
		while ((line = bufr.readLine()) != null) {
			String[] arr = line.split("=");
			System.out.println(arr[0] + ":" + arr[1]);
			prop.setProperty(arr[0], arr[1]);
		}
		bufr.close();

		System.out.println(prop);
	}

	// 设置和获取元素
	public static void setAndGet() {
		Properties prop = new Properties();

		prop.setProperty("zhangsan", "20");
		prop.setProperty("lisi", "30");

		System.out.println(prop);
		String value = prop.getProperty("lisi");
		System.out.println(value);

		prop.setProperty("lisi", "66");

		Set<String> names = prop.stringPropertyNames();
		for (String name : names) {
			System.out.println(name + " = " + prop.getProperty(name));
		}

	}

}
