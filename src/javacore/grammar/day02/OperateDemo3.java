package javacore.grammar.day02;

/**
 * 位运算符(练习2&三元运算符)<br>
 * <p>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day02-16-位运算符(练习2&三元运算符)
 */
public class OperateDemo3 {

	public static void main(String[] args) {

		System.out.println(Integer.toBinaryString(60));

		// 获取60的最低4位,通过&15.
		System.out.println(60 & 15);

		// 要获取下一组四位,将60右移4位.
		System.out.println(60 >> 4);

		// 对60的值进行最低四位的获取.
		System.out.println(60 & 15);

		int n = 60 & 15;
		// 三元运算符
		System.out.println((n > 9) ? (char) (n - 10 + 'A') : n);

	}

}
