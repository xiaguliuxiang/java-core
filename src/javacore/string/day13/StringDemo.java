package javacore.string.day13;

/**
 * String(概述)<br>
 * <p>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day13-01-String(概述)
 */
public class StringDemo {

	public static void main(String[] args) {
		// s1 是一个类类型变量, "abc"是一个对象.
		// 字符串最大特点:一旦被初始化就不可以被改变.
		String s1 = "abc";

		String s2 = new String("abc");

		/**
		 * s1 和 s2 有什么区别?<br>
		 * s1 在内存中有一个对象, s2 在内存中有两个对象.<br>
		 */

		System.out.println(s1 == s2);

		// String 类复写了 Object 类中的 equals() 方法.
		// 该方法用于判断字符串是否相同.
		System.out.println(s1.equals(s2));
	}

}
