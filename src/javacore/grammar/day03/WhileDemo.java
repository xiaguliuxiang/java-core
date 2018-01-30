package javacore.grammar.day03;

/**
 * 语句(while)<br>
 * 语句(do.while)<br>
 * <p>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day03-01-语句(while)
 * @see 传智播客毕向东Java基础视频教程-day03-02-语句(do.while)
 */
public class WhileDemo {

	public static void main(String[] args) {
		/**
		 * 定义初始化表达式;<br>
		 * while(条件表达式) { 循环体(执行语句); }<br>
		 */
		int x = 1;
		while (x < 3) {
			System.out.println("x = " + x);
			x++;
		}

		x = 3;
		do {
			System.out.println("x = " + x);
			x++;
		} while (x < 3);

		/**
		 * while:先判断条件，只有条件满足才执行循环体。<br>
		 * do-while:先执行循环体，再判断条件，条件满足，再继续执行循环体。<br>
		 * 简单一句话:do-while,无论条件是否满足，循环体至少执行一次。<br>
		 */
	}

}
