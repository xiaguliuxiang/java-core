package javacore.grammar.array.day04;

/**
 * 数组(常见操作-遍历)<br>
 * <p>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day04-02-数组(常见操作-遍历)
 */
public class ArrayDemo3 {

	public static void main(String[] args) {
		// 数组的操作：
		// 获取数组中的元素，通常会用到遍历。

		int[] arr = new int[3];
		System.out.println("arr[" + 0 + "] = " + arr[0] + ";"); // arr[0] = 0;

		int[] arr1 = { 3, 6, 5, 1, 8, 9 };
		// 数组中有一个属性可以直接获取到数组元素的个数:length.
		// 使用方式:数组名称.length
		System.out.println("length:" + arr1.length);
		for (int i = 0; i < arr1.length; i++) {
			System.out.println("arr1[" + i + "] = " + arr1[i] + ";");
		}

		System.out.println(arr1);

		printArray(arr1);
	}

	/**
	 * 定义功能，用于打印数组中的元素，元素间用逗号隔开。
	 */
	public static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
