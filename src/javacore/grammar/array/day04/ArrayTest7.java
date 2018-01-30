package javacore.grammar.array.day04;

/**
 * 数组(进制转换优化)<br>
 * <p>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day04-12-数组(进制转换优化)
 */
public class ArrayTest7 {

	public static void main(String[] args) {
		toBin(6);
		toOct(10);
		toHex(60);
	}

	/**
	 * 十进制-->二进制
	 */
	public static void toBin(int num) {
		trans(num, 1, 1);
	}

	/**
	 * 十进制-->八进制
	 */
	public static void toOct(int num) {
		trans(num, 7, 3);
	}

	/**
	 * 十进制-->十六进制
	 */
	public static void toHex(int num) {
		trans(num, 15, 4);
	}

	public static void trans(int num, int base, int offset) {
		if (num == 0) {
			System.out.println(0);
			return;
		}

		char[] chs = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		char[] arr = new char[32];

		int pos = arr.length;

		while (num != 0) {
			int temp = num & base;
			arr[--pos] = chs[temp];
			num = num >> offset;
		}

		for (int i = pos; i < arr.length; i++) {
			System.out.print(arr[i]);
		}

		System.out.println();

	}

}
