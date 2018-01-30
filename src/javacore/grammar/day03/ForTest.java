package javacore.grammar.day03;

/**
 * 语句(循环语句的其他特点)<br>
 * <p>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day03-05-语句(循环语句的其他特点)
 */
public class ForTest {

	public static void main(String[] args) {
		int x = 1;
		for (System.out.println("a"); x < 3; System.out.println("c")) {
			System.out.println("d");
			x++;
		}

		for (int i = 0; i < 3; i++) {
			System.out.println("i = " + i);
		}

		/**
		 * 无限循环的最简单的表现形式。<br>
		 * 
		 * <pre>
		 * for (;;) {
		 * }
		 * while (true) {
		 * }
		 * </pre>
		 */

	}

}
