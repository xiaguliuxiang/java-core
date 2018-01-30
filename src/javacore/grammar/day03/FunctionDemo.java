package javacore.grammar.day03;

/**
 * 函数(概述)<br>
 * <p>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day03-12-函数(概述)
 */
public class FunctionDemo {

	public static void main(String[] args) {
		int x = 4;
		System.out.println(x * 3 + 5);

		x = 6;
		System.out.println(x * 3 + 5);

		x = getResult(4);
		System.out.println("x = " + x);
		x = getResult(6);
		System.out.println("x = " + x);

	}

	/**
	 * 发现以上的运算，因为获取不同数据的运算结果，代码出现了重复。<br>
	 * 为了提高代码的服用性，对代码进行抽取。<br>
	 * 将这个部分成一个独立的功能，方便日后使用。<br>
	 * java 中对功能的定义是通过函数的形式来体现的。<br>
	 * 
	 * 1、先明确函数定义的形式。<br>
	 * 
	 * <pre>
	 * 修饰符 返回值类型 函数名(参数类型 形式参数1, 参数类型 形式参数2, ...) {
	 *     执行语句;
	 *     return 返回值;
	 * }
	 * </pre>
	 * 
	 * 当函数运算后，没有具体的返回值时，这时返回值类型用一个特殊的关键字来标识。<br>
	 * 该关键字就是 void, void: 代表的是函数没有具体返回值的情况。<br>
	 * 当函数的返回值类型是 void 时，函数中的 return 语句可以省略不写。<br>
	 */

	public static int getResult(int num) {
		return num * 3 + 5;
	}

}
