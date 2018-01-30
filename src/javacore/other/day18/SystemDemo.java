package javacore.other.day18;

import java.util.Properties;

/**
 * 其他对象(System)<br>
 * <p>
 * System:类中的方法和属性都是静态的。<br>
 * out:标准输出,默认是控制台。<br>
 * in:标准输入,默认是键盘。<br>
 * <p>
 * 描述一些系统信息。<br>
 * 
 * 获取系统属性信息：Properties getProperties();<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day18-01-其他对象(System)
 */
public class SystemDemo {

	public static void main(String[] args) {

		Properties prop = System.getProperties();

		/**
		 * 因为Properties 是 HashTable 的子类，也就是Map集合的一个子类对象。<br>
		 * 那么可以通过Map的方法去除该集合中的元素。<br>
		 * 该集合中存储都是字符串，没有泛型定义。<br>
		 */

		/**
		 * 如何在系统中自定义一些特有信息呢？<br>
		 */
		System.setProperty("myKey", "myValue");

		// 获取指定属性信息。
		String val = System.getProperty("os.name");
		System.out.println("os.name = " + val);

		// 可不可以在jvm启动时，动态加载一些属性信息呢？
		String v = System.getProperty("hh");
		System.out.println("v = " + v);

		// 获取所有属性信息。
		for (Object obj : prop.keySet()) {
			String value = (String) prop.get(obj);

			System.out.println(obj + " = " + value);
		}

	}

}
