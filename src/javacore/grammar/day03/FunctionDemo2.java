package javacore.grammar.day03;

/**
 * 函数(应用)<br>
 * <p>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day03-13-函数(应用)
 */
public class FunctionDemo2 {

	public static void main(String[] args) {
		int sum = getSum();
		System.out.println("sum = " + sum);

		sum = getSum(3, 5);
		System.out.println("sum = " + sum);

		boolean flag = compare(3, 4);
		System.out.println("flag = " + flag);

		int max = getMax(3, 4);
		System.out.println("max = " + max);

	}

	/**
	 * 如何定义一个函数呢？<br>
	 * 1、既然函数式一个独立的功能，那么该功能的运算结果是什么先明确。<br>
	 * 2、再明确在定义该功能的过程中是否需要为之的内容参与运算。<br>
	 * 
	 * 需求：定义一个功能，完成 3+4 的运算，并将结果返回给调用者。<br>
	 * 1、明确功能的结果：是一个整数的和。<br>
	 * 2、在实现该功能的过程中是否有位子内容参与运算，没有。<br>
	 * 其实这两个功能就是在明确函数的定义。<br>
	 * 1、是在明确函数的返回值类型。<br>
	 * 2、明确函数的参数列表(参数的类型和参数的个数)。<br>
	 */

	public static int getSum() {
		return 3 + 4;
	}

	/**
	 * 以上这个函数的功能，结果是固定的，毫无扩展性可言。<br>
	 * 为了方便用户需求，由用户来指定加数和被加数，这样，功能才有意义。<br>
	 * 思路：<br>
	 * 1、功能结果是一个和，返回值类型是 int。<br>
	 * 2、有为孩子内容参与运算，有两个，这两个位置内容的类型都是 int。<br>
	 */
	public static int getSum(int x, int y) {
		return x + y;
	}

	/**
	 * 需求：判断两个数是否相同。<br>
	 * 思路：<br>
	 * 1、明确功能的结果，结果是：boolean.<br>
	 * 2、功能是否有未知内容参与运算，有，两个参数。<br>
	 */
	public static boolean compare(int a, int b) {
		// if (a == b) {
		// return true;
		// } else {
		// return false;
		// }
		return a == b;
	}

	/**
	 * 需求：定义功能，对两个数进行比较，获取较大的数。
	 */
	public static int getMax(int x, int y) {
		if (x > y) {
			return x;
		} else {
			return y;
		}
	}

	/**
	 * 这个功能定义思想有问题，为什么呢？<br>
	 * 因为只为完成加法运算，至于是否要对和进行打印操作，那是调用者的事，不要在该功能中完成。<br>
	 * 
	 * @param x
	 * @param y
	 */
	public static void getSum1(int x, int y) {
		System.out.println(x + y);
		return;
	}

}
