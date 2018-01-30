package javacore.grammar.day02;

/**
 * 逻辑运算符<br>
 * 位运算符(左移右移)<br>
 * 位运算符(与-或-异或)<br>
 * 位运算符(练习)<br>
 * <p>
 * 练习:<br>
 * 1、最有效率的方式计算出2乘以8等于几?<br>
 * 2、对两个整数变量的值进行互换(不需要第三方变量)<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day02-12-逻辑运算符
 * @see 传智播客毕向东Java基础视频教程-day02-13-位运算符(左移右移)
 * @see 传智播客毕向东Java基础视频教程-day02-14-位运算符(与-或-异或)
 * @see 传智播客毕向东Java基础视频教程-day02-15-位运算符(练习)
 */
public class OpeaterDemo2 {

	public static void main(String[] args) {

		// 逻辑运算符用于连接boolean类型的表达式。

		// x > 3 & x < 6 = true & true = true;

		/**
		 * &:与<code>
		 * true & true = true;
		 * true & false = false;
		 * false & true = false;
		 * false & false = false;</code><br>
		 * &:只要两边的boolean表达式结果,有一个为false,那么结果就是false.<br>
		 * 只有两边都为true,结果为true.<br>
		 */

		/**
		 * |:或<code>
		 * true | true = true;
		 * true | false = false;
		 * false | true = false;
		 * false | false = false;</code><br>
		 * |:两边只要有一个为true,结果为true.<br>
		 * 只有两边都为false,结果为false.<br>
		 */

		/**
		 * ^:异或<code>
		 * true | true = false;
		 * true | false = true;
		 * false | true = true;
		 * false | false = false;</code><br>
		 * ^:两边相同结果为false.<br>
		 * 两边不同结果为true.<br>
		 * 特性:一个数异或同一个数两次,结果还是那个数.<br>
		 */

		/**
		 * &和&&的特点:<br>
		 * &:无论左边是true还是false,右边都运算.<br>
		 * &&:当左边为false时,右边不运算.<br>
		 */

		/**
		 * |和||的特点:<br>
		 * |:两边都参与运算.<br>
		 * ||:当左边为true,右边不运算.<br>
		 */

		/**
		 * ~:反码<br>
		 * ~6 = -7<br>
		 */

		System.out.println(false ^ false);

		System.out.println(~6);

		// 移位实现 2 * 8
		System.out.println(2 << 3);

		method_1(3, 5);
		method_2(3, 5);

	}

	/**
	 * 练习:对两个整数变量的值进行互换(不需要第三方变量)<br>
	 */
	public static void method_1(int x, int y) {
		System.out.println("x = " + x + ", y = " + y);
		// 注意:如果x,y的值非常大,容易造成数值溢出int范围.
		x = x + y;
		y = x - y;
		x = x - y;
		System.out.println("x = " + x + ", y = " + y);
	}

	/**
	 * 练习:对两个整数变量的值进行互换(不需要第三方变量)<br>
	 */
	public static void method_2(int x, int y) {
		System.out.println("x = " + x + ", y = " + y);
		// 注意:如果x,y的值非常大,容易造成数值溢出int范围.
		x = x ^ y;
		y = x ^ y;
		x = x ^ y;
		System.out.println("x = " + x + ", y = " + y);
	}
}
