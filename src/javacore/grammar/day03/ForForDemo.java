package javacore.grammar.day03;

/**
 * 语句(for嵌套)<br>
 * <p>
 * 语句嵌套形式，其实就是语句中还有语句。<br>
 * 循环嵌套。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day03-07-语句(for嵌套)
 */
public class ForForDemo {

	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print("*");
			}
			System.out.println();// 换行
		}

		for (int i = 0; i < 5; i++) {
			for (int j = i; j < 5; j++) {
				System.out.print("*");
			}
			System.out.println();// 换行
		}
	}

	/**
	 * 对于打印长方形：<br>
	 * 外循环控制行数，内循环控制每一行的列数，也就是每一行中元素的个数。<br>
	 */

}
