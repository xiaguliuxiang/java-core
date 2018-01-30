package javacore.grammar.array.day04;

/**
 * 数组(静态初始化-常见问题)<br>
 * <p>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day04-01-数组(静态初始化-常见问题)
 */
public class ArrayDemo2 {

	public static void main(String[] args) {
		int[] arr1 = new int[5];
		int arr2[] = new int[2];
		int[] arr3 = new int[] { 1, 3, 4 };
		int[] arr4 = { 3, 1, 5, 4, 2 };
		int[] arr5 = new int[5];
		arr5[0] = 90;
		arr5[1] = 88;
		System.out.println(arr1[0]);
		System.out.println(arr2[0]);
		System.out.println(arr3[0]);
		System.out.println(arr4[0]);
		System.out.println(arr5[0]);

		try {
			System.out.println(arr5[5]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("数组越界了");
		}

		// NullPointerException:空指针异常，当引用了没有任何指向值为null的情况，该引用还在用于操作实体。
	}

}
