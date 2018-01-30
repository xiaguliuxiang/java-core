package javacore.grammar.day03;

/**
 * 语句(for)<br>
 * 语句(for和while的区别)<br>
 * <p>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day03-03-语句(for)
 * @see 传智播客毕向东Java基础视频教程-day03-04-语句(for和while的区别)
 */
public class ForDemo {

	public static void main(String[] args) {

		for (int i = 0; i < 3; i++) {
			System.out.println("i = " + i);
		}

		int j = 0;
		while (j < 3) {
			System.out.println("j = " + j);
			j++;
		}

		/**
		 * <pre>
		 * 1、变量有自己的作用域，对于for来讲：如果将用于控制循环的增量定义在for语句中，
		 *     那么该变量只有在for语句中才有效。for语句执行完毕，该变量在内存中释放。
		 * 
		 * 2、for和while可以进行互换。如果需要定义循环增量，用for更为合适。
		 * 
		 * 总结:什么时候使用循环结构?
		 *     当要对某些语句执行很多次时，就使用循环结构。
		 * </pre>
		 */
	}

}
