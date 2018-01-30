package javacore.collection.day17;

import java.util.Arrays;
import java.util.List;

/**
 * 集合(Arrays)<br>
 * <p>
 * Arrays:用于操作数组的工具类。<br>
 * 里面都是静态方法。<br>
 * <br>
 * asList:将数组变成list集合。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day17-16-集合(Arrays)
 */
public class ArraysDemo {
	public static void main(String[] args) {
		int[] arr = { 2, 4, 5 };
		System.out.println(Arrays.toString(arr));

		String[] arr1 = { "abc", "cc", "kkkk" };
		/**
		 * 把数组变成list集合有什么好处?<br>
		 * 可以使用集合的思想和方法来操作数组中的元素。<br>
		 * 注意：将数组变成集合，不可以使用集合的增删方法。<br>
		 * 因为数组的长度是固定的。<br>
		 * contains();<br>
		 * get();<br>
		 * indexOf();<br>
		 * subList();<br>
		 * 如果你增删，那么会发生UnsupportedOperationException.<br>
		 */
		List<String> list1 = Arrays.asList(arr1);
		sop("contains:" + list1.contains("cc"));
		// list1.add("qq"); // UnsupportedOperationException
		sop(list1);

		int[] nums = { 2, 4, 5 };
		/**
		 * 如果数组中的元素都是对象，那么编程集合时，数组中的元素就直接转成集合中的元素。<br>
		 * 如果数组中的元素都是基本数据类型，那么会将该数组作为集合中的元素存在。<br>
		 */
		List<int[]> list2 = Arrays.asList(nums);
		sop(list2);

		Integer[] nums2 = { 2, 4, 5 };
		List<Integer> list3 = Arrays.asList(nums2);
		sop(list3);

	}

	public static void sop(Object obj) {
		System.out.println(obj);
	}
}
