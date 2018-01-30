package javacore.object_oriented.day06;

/**
 * 面向对象(静态的应用-工具类)<br>
 * 面向对象(帮助文档的制作javadoc)<br>
 * <p>
 * 静态的应用。<br>
 * 每一个应用程序中都有共性的功能。<br>
 * 可以将这些功能进行抽取，独立封装。以便复用。<br>
 * <br>
 * 虽然可以通过建立ArrayTool的对象使用这些工具方法，对数组进行操作。<br>
 * 但是发现了问题：<br>
 * 1、对象是用于封数据的，可是ArrayTool对象并未封住nga特有数据。<br>
 * 2、操作数组的每一个方法都没有用到ArrayTool对象中的特有数据。<br>
 * <br>
 * 这时就考虑，让程序更严谨，是不需要对象的。<br>
 * 可以将ArrayTool中的方法都定义成static的，直接通过类名调用即可。<br>
 * <br>
 * 将方法都静态后，可以方便于使用，但是该类还是可以被其他程序建立对象的。<br>
 * 为了更加严谨，强制让该类不能建立对象。<br>
 * 可以通过将构造函数私有化完成。<br>
 * <br>
 * 接下来，将ArrayTool.class文件发送给其他人，其他人只要将该文件设置到classpath路径下，<br>
 * 就可以使用该工具类。<br>
 * 但是，很遗憾，该类中到底定义了多少个方法，对方全不清楚。因为该类并没有使用说明书。<br>
 * <br>
 * 开始制作程序的说明书，java的说明书通过文档注释来完成。<br>
 * <code>
 * javadoc -d myhelp -author -version ArrayTool.java
 * </code>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day06-04-面向对象(静态的应用-工具类)
 * @see 传智播客毕向东Java基础视频教程-day06-05-面向对象(帮助文档的制作javadoc)
 */
public class ArrayTool {

	public static void main(String[] args) {
		int[] arr = { 3, 4, 1, 8 };

		int max = getMax(arr);
		System.out.println("max = " + max);
	}

	/**
	 * 一个类中默认会有一个空参数的构造函数。<br>
	 * 这个默认的构造函数的权限和所属类一致。<br>
	 * 如果类被public修饰，那么默认的构造函数也带public修饰符。<br>
	 * 如果类没有被public修饰，那么默认的构造函数，也没有public修饰。<br>
	 * 默认构造函数的权限是随着类的变化而变化的。
	 */

	/**
	 * 无参构造函数私有化,强制让该类不能建立对象.
	 */
	private ArrayTool() {
	}

	/**
	 * 获取一个整形数组中的最大值。
	 * 
	 * @param arr
	 *            接收一个int类型的数组。
	 * @return 会返回一个该数组中最大值。
	 */
	public static int getMax(int[] arr) {
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > arr[max]) {
				max = i;
			}
		}
		return arr[max];
	}

	/**
	 * 获取一个整形数组中最小值。
	 * 
	 * @param arr
	 *            接收一个int类型的数组。
	 * @return 会返回一个该数组中最小值。
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
	 * 给int数组进行选择排序
	 * 
	 * @param arr
	 *            接收一个int类型的数组。
	 */
	public static void selectSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = (i + 1); j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					swap(arr, i, j);
				}
			}
		}
	}

	/**
	 * 给int数组进行冒泡排序
	 * 
	 * @param arr
	 *            接收一个int类型的数组。
	 */
	public static void bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					swap(arr, j, j + 1);
				}
			}
		}
	}

	/**
	 * 给数组中的元素进行位置的置换。
	 * 
	 * @param arr
	 *            接收一个int类型的数组。
	 * @param a
	 *            要置换的位置
	 * @param b
	 *            要置换的位置
	 */
	private static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	/**
	 * 用于打印数组中的元素。<br>
	 * 打印形式是：[element1, element2, ...]
	 * 
	 * @param arr
	 *            接收一个int类型的数组。
	 */
	public static void printArray(int[] arr) {
		System.out.print("[");
		for (int i = 0; i < arr.length; i++) {
			if (i != (arr.length - 1)) {
				System.out.print(arr[i] + ", ");
			} else {
				System.out.println(arr[i] + "]");
			}
		}
	}

}
