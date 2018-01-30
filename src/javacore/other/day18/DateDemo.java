package javacore.other.day18;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 其他对象(Date)<br>
 * <p>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day18-03-其他对象(Date)
 */
public class DateDemo {

	public static void main(String[] args) {

		Date d = new Date();
		System.out.println(d); // 打印的事件看不懂，希望有些格式，那么下面就设置格式。

		// 将模式封装到SimpleDateFormat对象中。
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");

		// 调用format()方法让模式格式化指定Date对象。
		String time = sdf.format(d);

		System.out.println("time = " + time);

		sdf = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
		time = sdf.format(d);
		System.out.println("time = " + time);

		sdf = new SimpleDateFormat("yyyy年MM月dd日E HH:mm:ss");
		time = sdf.format(d);
		System.out.println("time = " + time);

	}

}
