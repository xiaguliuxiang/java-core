package javacore.grammar.array.day04;

/**
 * 数组(排序-冒泡排序)<br>
 * <p>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day04-05-数组(排序-冒泡排序)
 */
public class ArrayTest3 {

	public static void main(String[] args) {
		int[] arr = { 5, 1, 6, 4, 2, 8, 9 };
		// 在排序前打印
		printArray(arr);

		// 排序
		bubbleSort(arr);

		// 排序后打印
		printArray(arr);
	}

	/**
	 * 冒泡排序<br>
	 */
	public static void bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			// -x:让每一次比较的元素减少;-1:避免角标越界.
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
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
