package javacore.grammar.day02;

/**
 * 变量<br>
 * 类型转换<br>
 * <p>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day02-07-变量
 * @see 传智播客毕向东Java基础视频教程-day02-08-类型转换
 */
public class VarDemo {

	public static void main(String[] args) {
		// 定义变量的格式：
		// 数据类型 变量名 = 初始化值;

		// 定义一个int类型变量,取值为4;

		int x = 4;
		System.out.println(x);

		x = 10;
		System.out.println(x);

		// 演示其他数据类型。
		byte b = 2; // -128-127
		System.out.println(b);

		short s = 3000;
		System.out.println(s);

		// long或者Long初始赋值时,必须使用大写的L,不能使小写的l,小写容易跟数字1混淆,造成误解.
		long l = 4L;
		System.out.println(l);

		float f = 2.3f;
		System.out.println(f);

		double d = 34.56;
		System.out.println(d);

		char ch = '4';
		System.out.println(ch);
		char ch1 = 'a';
		System.out.println(ch1);
		char ch2 = '+';
		System.out.println(ch2);
		char ch3 = ' ';
		System.out.println(ch3);

		boolean bo1 = true;
		System.out.println(bo1);
		boolean bo2 = false;
		System.out.println(bo2);

		/**
		 * 什么时候定义变量?<br>
		 * 当数据不确定的时候，需要对数据进行存储时，<br>
		 * 就是定义一个变量来完成存储动作。<br>
		 */

		int a = 5;
		a += 6;
		System.out.println(a);

		// 类型转换
		byte by = 3;
		by = (byte) (by + 2);
		System.out.println(by);

		System.out.println('a' + 1);

	}

}
