package javacore.grammar.array.day04;

/**
 * 数组(二维数组)<br>
 * 数组(二维数组练习)<br>
 * <p>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day04-13-数组(二维数组)
 * @see 传智播客毕向东Java基础视频教程-day04-14-数组(二维数组练习)
 */
public class Array2Demo {

	public static void main(String[] args) {
		int[] arr1 = new int[3]; // 一维数组
		System.out.println(arr1.length);
		int[][] arr2 = new int[3][4];// 定义了名称为arr的二维数组。
		// 二维数组中有三个一维数组。每一个一维数组中四个元素。
		System.out.println(arr2.length);

		// System.out.println(arr2[0][1]);

		int[][] arr3 = new int[3][];
		arr3[0] = new int[3];
		arr3[1] = new int[1];
		arr3[2] = new int[2];

		// System.out.println(arr21[0]);

		System.out.println(arr3.length); // 打印的是二维数组的长度3
		System.out.println(arr3[0].length); // 打印二维数组中第一个一维数组的长度

		int[][] arr = { { 3, 5, 1, 7 }, { 2, 3, 5, 8 }, { 6, 1, 8, 2 } };

		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				sum = sum + arr[i][j];
			}
		}
		System.out.println("sum = " + sum);
	}

}
