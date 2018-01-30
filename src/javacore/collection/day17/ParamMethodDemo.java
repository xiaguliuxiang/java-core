package javacore.collection.day17;

/**
 * 集合(可变参数)<br>
 * <p>
 * JDK1.5版本出现的新特性。<br>
 * 方法的可变参数。<br>
 * 在使用时注意，可变参数一定要定义在参数列表的最后面。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day17-19-集合(可变参数)
 */
public class ParamMethodDemo {

	public static void main(String[] args) {
		show(3, 4);

		/**
		 * 虽然少定义了多个方法。<br>
		 * 但是每次都要定义一个数组，作为实际参数。<br>
		 */
		int[] arr = { 3, 4 };
		show(arr);

		int[] arr1 = { 2, 3, 4, 5 };
		show(arr1);

		/**
		 * 可变参数。<br>
		 * 其实就是上一中数组参数的简写形式。<br>
		 * 不用每一次都手动的建立数组对象。<br>
		 * 只需要将要操作的元素作为参数传递即可。<br>
		 * 隐式地将这些参数封装成了数组。<br>
		 */
		show2(2, 3, 4, 5);
		show2(2, 3, 4, 5, 6, 7, 8);
		show2();

		show2("哈哈", 2, 3, 4, 5);
	}

	public static void show2(String str, int... arr) {
		System.out.println(arr.length);
	}

	public static void show2(int... arr) {
		System.out.println(arr.length);
	}

	public static void show(int a, int b) {
		System.out.println(a + "," + b);
	}

	public static void show(int[] arr) {
		for (int i : arr) {
			System.out.println(i);
		}
	}

}
