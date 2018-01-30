package javacore.grammar.day03;

/**
 * 函数(练习)<br>
 * <p>
 * 练习题<br>
 * 1、定义一个功能，用于打印矩形。<br>
 * 2、定义一个打印九九乘法表功能的函数。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day03-14-函数(练习)
 */
public class FunctionTest {

	public static void main(String[] args) {

		draw(5, 6);
		printHr();

		draw(7, 9);
		printHr();

		print99();

	}

	/**
	 * 定义一个功能，用于打印矩形。<br>
	 * 思路：<br>
	 * 1、确定结果：没有，因为直接打印，所以返回值类型是 void.<br>
	 * 2、有未知内容吗？有两个，因为矩形的行和列不确定。<br>
	 */
	public static void draw(int row, int col) {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void printHr() {
		System.out.println("-------------------------");
	}

	/**
	 * 定义一个打印九九乘法表功能的函数。
	 */
	public static void print99() {
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j + "*" + i + "= " + i * j + "\t");
			}
			System.out.println();
		}
	}

}
