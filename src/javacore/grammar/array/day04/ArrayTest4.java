package javacore.grammar.array.day04;

/**
 * 数组(折半查找)<br>
 * <p>
 * 练习：<br>
 * 有一个有序的数组，想要讲一个元素插入到该数组中，还要保证该数组是有序的。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day04-07-数组(折半查找)
 */
public class ArrayTest4 {

	public static void main(String[] args) {
		int[] arr = { 5, 1, 6, 4, 2, 8, 9 };

		int index = getIndex(arr, 2);
		System.out.println("index = " + index);

		int[] arr1 = { 2, 4, 5, 7, 19, 32, 45 };
		int index1 = halfSearch(arr1, 32);
		System.out.println("index1 = " + index1);

		int index2 = halfSearch_2(arr1, 7);
		System.out.println("index2 = " + index2);

		int index3 = getIndex_2(arr1, 19);
		System.out.println("index3 = " + index3);

	}

	/**
	 * 定义功能，获取key第一次出现在数组中的位置。<br>
	 * 如果返回是-1，那么代表该key在数组中不存在。<br>
	 * 
	 * @param arr
	 * @param key
	 * @return
	 */
	public static int getIndex(int[] arr, int key) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == key) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * 折半查找。<br>
	 * 提高效率，但是必须要保证该数组是有序的数组。<br>
	 */
	public static int halfSearch(int[] arr, int key) {
		int min, max, mid;
		min = 0;
		max = arr.length - 1;
		mid = (max + min) / 2;

		while (arr[mid] != key) {
			if (key > arr[mid]) {
				min = mid + 1;
			} else if (key < arr[mid]) {
				max = mid - 1;
			}
			if (min > max) {
				return -1;
			}
			mid = (max + min) / 2;
		}
		return mid;
	}

	/**
	 * 折半的第二种方式。<br>
	 */
	public static int halfSearch_2(int[] arr, int key) {
		int min = 0, max = arr.length - 1, mid;

		while (min <= max) {
			mid = (max + min) / 2;

			if (key > arr[mid]) {
				min = mid + 1;
			} else if (key < arr[mid]) {
				max = mid - 1;
			} else {
				return mid;
			}
		}
		return -1;
	}

	public static int getIndex_2(int[] arr, int key) {
		int min = 0, max = arr.length - 1, mid;

		while (min <= max) {
			mid = (max + min) >> 1;

			if (key > arr[mid]) {
				min = mid + 1;
			} else if (key < arr[mid]) {
				max = mid - 1;
			} else {
				return mid;
			}
		}
		return min;
	}

}
