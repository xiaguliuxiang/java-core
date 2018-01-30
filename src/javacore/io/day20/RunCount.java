package javacore.io.day20;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * IO流(Properties练习)<br>
 * <p>
 * 用于记录应用程序运行次数。<br>
 * 如果使用次数已到，那么给出注册提示。<br>
 * <p>
 * 很容易想到的是：计数器。<br>
 * 可是该计数器定义在程序中，随着程序的运行而在内存中存在，并进行自增。<br>
 * 可是随着该应用程序的退出，该计数器也在内存中消失了。<br>
 * 
 * 下一次再启动该陈旭，又重新开始从0计数。<br>
 * 这样不是我们想要的。<br>
 * 
 * 程序即使结束，该计数器的值也存在。<br>
 * 下次程序启动时会先加载该计数器的值并加1后再重新存储起来。<br>
 * 
 * 所以，需要建立一个配置文件，用于记录该软件的使用次数。<br>
 * 
 * 该配置文件使用键值对的形式。<br>
 * 这样便于阅读数据，并操作数据。<br>
 * 
 * 键值对数据是Map集合。<br>
 * 数据是以文本形式存储，使用IO技术。<br>
 * 那么 map + io --> properties.<br>
 * 
 * 配置文件可以实现应用程序数据的共享。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day20-14-IO流(Properties练习)
 */
public class RunCount {

	public static void main(String[] args) throws IOException {
		Properties prop = new Properties();

		File file = new File("file" + File.separator + "count.ini");
		if (!file.exists()) {
			file.createNewFile();
		}

		FileInputStream fis = new FileInputStream(file);

		prop.load(fis);

		int count = 0;
		String value = prop.getProperty("time");

		if (value != null) {
			count = Integer.parseInt(value);
			if (count >= 5) {
				System.out.println("您好，试用次数已到，请付费后继续使用！");
				return;
			} else {
				System.out.println("您好，本次是您第" + count + "次试用！");
			}
		}
		count++;
		prop.setProperty("time", count + "");

		FileOutputStream fos = new FileOutputStream(file);
		prop.store(fos, "");

		fos.close();
		fis.close();
	}
}
