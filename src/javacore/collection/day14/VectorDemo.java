package javacore.collection.day14;

import java.util.Enumeration;
import java.util.Vector;

/**
 * 集合框架(Vector中的枚举)<br>
 * <p>
 * 枚举就是Vector特有的取出方式。<br>
 * 发现枚举和迭代器很像。<br>
 * 其实枚举和迭代时一样的。<br>
 * <br>
 * 因为枚举的名称以及方法的名称都过长，所以被迭代器取代了。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day14-07-集合框架(Vector中的枚举)
 */
public class VectorDemo {

	public static void main(String[] args) {
		Vector<String> v = new Vector<String>();

		v.add("java01");
		v.add("java02");
		v.add("java03");
		v.add("java04");

		Enumeration<String> en = v.elements();
		while (en.hasMoreElements()) {
			System.out.println(en.nextElement());
		}
	}

}
