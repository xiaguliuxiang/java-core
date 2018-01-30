package javacore.grammar.array.day04;

/**
 * 数组(十进制-二进制)<br>
 * 数组(十进制-十六进制)<br>
 * <p>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day04-08-数组(十进制-二进制)
 * @see 传智播客毕向东Java基础视频教程-day04-09-数组(十进制-十六进制)
 */
public class ArrayTest5 {

	public static void main(String[] args) {
		toBin(6);
		System.out.println(Integer.toBinaryString(6));

		toHex(60);
	}

	/**
	 * 十进制 --> 十六进制
	 */
	public static void toHex(int num) {
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < 8; i++) {
			int temp = num & 15;
			if (temp > 9) {
				// System.out.println((char) temp - 10 + 'A');
				sb.append((char) (temp - 10 + 'A'));
			} else {
				// System.out.println(temp);
				sb.append(temp);
			}
			num = num >>> 4;
		}
		System.out.println(sb.reverse());
	}

	/**
	 * 十进制 --> 二进制
	 */
	public static void toBin(int num) {
		StringBuffer sb = new StringBuffer();

		while (num > 0) {
			sb.append(num % 2);
			num = num / 2;
		}
		System.out.println(sb.reverse());
	}

}
