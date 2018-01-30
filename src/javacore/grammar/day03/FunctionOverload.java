package javacore.grammar.day03;

/**
 * 函数(重载)<br>
 * 函数(重载练习)<br>
 * <p>
 * 什么时候用重载？<br>
 * 当定义的功能相同，但参与运算的位置内容不同。<br>
 * 那么，这时就定义一个函数名称以表示其功能，方便阅读，而通过参数列表的不同来<br>
 * 区分多个同名函数。<br>
 * 
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day03-15-函数(重载)
 * @see 传智播客毕向东Java基础视频教程-day03-16-函数(重载练习)
 */
public class FunctionOverload {

	public static void main(String[] args) {

		add(4, 5);
		add(4, 5, 6);
	}

	/**
	 * 定义一个加法运算，获取两个整数的和。
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public static int add(int x, int y) {
		return x + y;
	}

	/**
	 * 定义一个加法运算，获取三个整数的和。
	 * 
	 * @param x
	 * @param y
	 * @param z
	 * @return
	 */
	public static int add(int x, int y, int z) {
		return x + y + z;
	}

	/**
	 * void show(int a, char b, double c);<br>
	 * a. void show(int x, char y, double z); // 没有重载，因为和原函数一样。<br>
	 * b. int show(int a, double c, char b); // 重载，因为参数类型不同。<br>
	 * c. void show(int a, double c,char b); // 重载，因为参数类型不同。注意：重载和返回值类型没有关系。<br>
	 * d. boolean show(int c, char b); // 重载，因为参数个数不同。<br>
	 * e. void show(double c); // 重载，因为参数个数不同。<br>
	 * f. double show(int x, char y, double z); // 没有重载，因为和原函数的参数一样。<br>
	 */

}
