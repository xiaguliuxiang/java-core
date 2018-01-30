package javacore.grammar.day03;

/**
 * 语句(for嵌套练习)<br>
 * 语句(for嵌套-九九乘法表)<br>
 * <p>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day03-08-语句(for嵌套练习)
 * @see 传智播客毕向东Java基础视频教程-day03-09-语句(for嵌套-九九乘法表)
 */
public class ForForTest {

	public static void main(String[] args) {

		/**
		 * 不是规律的规律：<br>
		 * 尖朝上，可以改变条件，让条件随着外循环变化。<br>
		 * 尖朝下，可以初始化值，让初始化随着外循环变化。<br>
		 */

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		for (int i = 0; i < 5; i++) {
			for (int j = 5; j > i; j--) {
				System.out.print("*");
			}
			System.out.println();
		}

		/**
		 * 九九乘法表
		 */
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j + "*" + i + "=" + i * j + "\t");
			}
			System.out.println();
		}

	}
}
