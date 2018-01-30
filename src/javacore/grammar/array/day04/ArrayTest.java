package javacore.grammar.array.day04;

/**
 * 数组(常见操作-获取最值)<br>
 * <p>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day04-03-数组(常见操作-获取最值)
 */
public class ArrayTest {

	public static void main(String[] args) {
		int[] arr = { 5, 1, 6, 4, 2, 8, 9 };

		int max = getMax(arr);
		System.out.println("max = " + max);

		int max_2 = getMax_2(arr);
		System.out.println("max_2 = " + max_2);

		int min = getMin(arr);
		System.out.println("min = " + min);

		boolean[] ar = new boolean[3];
		System.out.println(ar[1]);
	}

	/**
	 * 获取数组中的最大值。<br>
	 * 思路：<br>
	 * 1、获取最值需要进行比较，每一次比较都会有一个较大的值，因为该值不确定，<br>
	 * 通过一个变量进行存储。<br>
	 * 2、让数组中的每一个元素都和这个变量中的值进行比较。<br>
	 * 如果大于了变量中的值，就用该变量记录较大值。<br>
	 * 3、当所有的元素都比较完成，那么该变量中存储的就是数组中的最大值了。<br>
	 * <br>
	 * 步骤：<br>
	 * 1、定义变量，初始化为数组中任意一个元素即可。<br>
	 * 2、通过循环语句对数组进行遍历。<br>
	 * 3、在变量过程中定义判断条件，如果遍历到的元素比变量中的元素大，就赋值给该变量。<br>
	 * <br>
	 * 需要定义一个功能来完成，以便提高复用性。<br>
	 * 1、明确结果：数组中的最大元素 int.<br>
	 * 2、未知内容：一个数组。int[].<br>
	 */
	public static int getMax(int[] arr) {
		int max = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		return max;
	}

	/**
	 * 获取最大值的另一种方式。<br>
	 * 可不可以将临时变量初始化为0呢?<br>
	 * 可以，这种方式，其实是在初始化为数组中任意一个角标。<br>
	 */
	public static int getMax_2(int[] arr) {
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > arr[max]) {
				max = i;
			}
		}
		return arr[max];
	}

	/**
	 * 获取最小值
	 * 
	 * @param arr
	 * @return
	 */
	public static int getMin(int[] arr) {
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < arr[max]) {
				max = i;
			}
		}
		return arr[max];
	}

	/**
	 * 获取double类型数组的最大值。<br>
	 * 因为功能一致，所以定义相同的函数名称，以重载形式存在。
	 * 
	 * @param arr
	 * @return
	 */
	public static double getMax(double[] arr) {
		return 0;
	}

}
