package javacore.grammar.day02;

/**
 * 算术运算符<br>
 * 转义字符<br>
 * <p>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day02-09-算术运算符
 * @see 传智播客毕向东Java基础视频教程-day02-10-转义字符
 */
public class OperateDemo {

	public static void main(String[] args) {

		int x = 4270;
		x = x / 1000 * 1000;
		System.out.println(x);

		System.out.println(-1 % 5);

		int a = 3, b;

		a++; // a = a + 1;
		a = a + 3;

		b = a++;

		System.out.println(a);
		System.out.println(b);

		b = ++a;
		System.out.println(a);
		System.out.println(b);

		// 字符串数据和任何数据使用+都是相连接，最终都会变成字符串。
		System.out.println("aaa" + "bbb");
		System.out.println("aaa" + "bbb" + 5 + 5);
		System.out.println("5+5" + 5 + 5);
		System.out.println("5+5" + (5 + 5));

		/**
		 * 转义字符：通过\ 来转变后面字母或者符号的含义。<br>
		 * \n:换行.<br>
		 * \b:退格,相当于backspace.<br>
		 * \r:按下回车键,Windows系统,回车符是由两个字符来表示\r\n.<br>
		 * \t:制表符,相当于tab键.<br>
		 */
		System.out.println("hello\nworld");
		System.out.println("hello\bworld");
		System.out.println("hello\rworld");
		System.out.println("hello\tworld");
		System.out.println("\"hello world\"");

	}

}
