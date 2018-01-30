package javacore.grammar.array.day04;

/**
 * 数组(查表法十进制-十六进制)<br>
 * 数组(查表法十进制-二进制)<br>
 * <p>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day04-10-数组(查表法十进制-十六进制)
 * @see 传智播客毕向东Java基础视频教程-day04-11-数组(查表法十进制-二进制)
 */
public class ArrayTest6 {

	public static void main(String[] args) {
		toHex(60);
		toHex(-60);

		toBin(6);
	}

	public static void toBin(int num) {
		// 定义二进制的表
		char[] chs = { '0', '1' };

		// 定义一个临时存储容器
		char[] arr = new char[32];

		// 定义一个操作数组的指针
		int pos = arr.length;

		while (num != 0) {
			int temp = num & 1;
			arr[--pos] = chs[temp];
			num = num >>> 1;
		}
		for (int i = pos; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
		System.out.println();
	}

	/**
	 * <pre>
	 * 0  1  2  3  4  5  6  7  8  9  A  B  C  D  E  F  <--十六进制中的元素
	 * 0  1  2  3  4  5  6  7  8  9  10 11 12 13 14 15 <--对应的十进制数值
	 * 
	 * 查表法：将所有的元素临时存储起来，建立对应关系。
	 * 每一次 &15 后的值作为索引去查建立好的表，就可以找到对应的元素。
	 * 这样比 (-10+'A')简单的多。
	 * 
	 * 这个表怎么建立呢？
	 * 可以通过数据的形式来定义。
	 * 
	 * 发现终于出结果。但是是反着的，想要正过来呢？
	 * 可以通过 StringBuffer reverse() 功能来完成。
	 * 
	 * 所以可以使用已经学习过的容器：数组来完成存储。
	 * 
	 * </pre>
	 */
	public static void toHex(int num) {
		char[] chs = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

		// 定义一个临时容器。
		char[] arr = new char[8];
		int pos = arr.length;

		while (num != 0) {
			int temp = num & 15;
			arr[--pos] = chs[temp];

			num = num >>> 4;
		}

		// System.out.println(pos);

		// 存储数据的 arr 数组遍历
		for (int i = pos; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
		System.out.println();
	}

}
