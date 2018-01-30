package javacore.grammar.day03;

/**
 * 语句(for语句练习-累加&计数器)<br>
 * <p>
 * 1、获取1-10的和，并打印。<br>
 * 2、1-100之间的7的倍数的个数，并打印。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day03-06-语句(for语句练习-累加&计数器)
 */
public class ForTest2 {

	public static void main(String[] args) {
		method_1();
		method_2();
	}

	public static void method_1() {
		// 1、定义变量用于存储不断变化的和。
		int sum = 0;
		// 2、定义变量，记录不断变化的被加的数。
		int x = 1;
		// 3、定义循环，重复加法的过程。
		while (x <= 10) {
			sum += x;
			x++;
		}
		System.out.println("sum = " + sum);
	}

	/**
	 * <pre>
	 * 需求:1-100之间的7的倍数的个数，并打印。
	 * 思路：
	 *     1、先对1-100进行循环(遍历)通过循环的形式。
	 *     2、在遍历的过程中，定义条件。只对7的倍数进行操作。
	 * 步骤：
	 *     1、定义循环语句，选择for语句。
	 *     2、在循环中定义判断，只要是7的倍数即可。使用if语句，条件：7的倍数 x%7==0;
	 *     3、定义变量，该变量随着7的倍数的出现而自增。
	 * </pre>
	 */
	public static void method_2() {
		int count = 0;
		for (int i = 0; i < 100; i++) {
			if (i % 7 == 0) {
				count++;
			}
		}
		System.out.println("count = " + count);

		/**
		 * 计数器思想。<br>
		 * 通过一个变量记录住数据的状态变化，也许通过循环完成。<br>
		 */

	}
}
