package javacore.grammar.array.day04;

/**
 * 数组(排序-选择排序)<br>
 * <p>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day04-04-数组(排序-选择排序)
 */
public class ArrayTest2 {

	public static void main(String[] args) {
		int[] arr = { 5, 1, 6, 4, 2, 8, 9 };
		// 在排序前打印
		printArray(arr);

		// 排序
		selectSort(arr);

		// 排序后打印
		printArray(arr);
	}

	/**
	 * 选择排序。<br>
	 * 内循环结束一次，最值出现头角标位置上。<br>
	 */
	public static void selectSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}

	public static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (i == 0) {
				System.out.print("[" + arr[i] + "\t");
			} else if (i == arr.length - 1) {
				System.out.println(arr[i] + "]");
			} else {
				System.out.print(arr[i] + "\t");
			}
		}
	}

}
