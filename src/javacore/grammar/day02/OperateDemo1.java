package javacore.grammar.day02;

/**
 * 赋值和比较运算符<br>
 * <p>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day02-11-赋值和比较运算符
 */
public class OperateDemo1 {

	public static void main(String[] args) {
		// += -= *= /= %=
		int x = 3;

		x += 4; // x = x + 4;

		short s = 4;
		// s = s + 5;
		s += 5;

		int a, b, c;
		a = b = c = 5;

		System.out.println("x = " + x);
		System.out.println("s = " + s);

		System.out.println("a = " + a + ", b = " + b + ", c = " + c);

		System.out.println(3 == 4);
		System.out.println(3 != 4);
	}

}
