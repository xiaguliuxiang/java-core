package javacore.grammar.day03;

/**
 * 语句(break-continue)<br>
 * <p>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day03-10-语句(break-continue)
 */
public class OtherDemo {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		// break
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.println("i = " + i);
				break;
			}
		}

		// continue:只能作用于循环结构，继续循环。
		// 特点:结束本次循环，继续下一次循环。
		for (int i = 0; i < 10; i++) {
			if (i % 2 == 1) {
				continue;
			}
			System.out.println("i = " + i);
		}

		for (int i = 0; i < 5; i++) {
			for (int j = i + 1; j < 5; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j <= i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}

		w: for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.println("i * j = " + i * j);
				continue w;
			}
		}

		/**
		 * 记住：<br>
		 * 1、break 和 continue 语句作用的范围。<br>
		 * 2、break 和 continue 单独存在时，下面不可以有任何语句，因为执行不到，所以编译会报错。<br>
		 */

	}

}
