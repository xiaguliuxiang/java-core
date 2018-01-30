package javacore.grammar.day03;

/**
 * 语句(练习)<br>
 * <p>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day03-11-语句(练习)
 */
public class ForForTest2 {

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			for (int j = i + 1; j < 5; j++) {
				System.out.print("  ");
			}
			for (int j = 0; j <= i; j++) {
				System.out.print(" * ");
			}
			System.out.println();
		}
	}

}
