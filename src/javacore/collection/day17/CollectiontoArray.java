package javacore.collection.day17;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 集合(集合转成数组)<br>
 * <p>
 * 集合变数组.<br>
 * Collection 接口中的toArray() 方法。<br>
 * <p>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day17-17-集合(集合转成数组)
 */
public class CollectiontoArray {

	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<String>();

		al.add("abc1");
		al.add("abc2");
		al.add("abc3");

		/**
		 * <pre>
		 * 1、指定类型的数组到底要定义多长呢？
		 *     当指定类型的数组长度小于集合的 size, 那么该方法内部会创建一个新的数组，长度为集合的 size。
		 *     当指定类型的数组长度大于集合的 size, 就不会创建新的数组，而是使用传递进来的数组。
		 *     所以，创建一个刚刚好的数组最优。
		 * 2. 为什么要将集合变数组？
		 *     为了限定对元素的操作，不需要进行增删了。
		 * </pre>
		 */

		String[] arr = al.toArray(new String[al.size()]);
		System.out.println(Arrays.toString(arr));

	}

}
