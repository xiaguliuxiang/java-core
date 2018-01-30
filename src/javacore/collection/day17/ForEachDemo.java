package javacore.collection.day17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 集合(增强for循环)<br>
 * <p>
 * 对集合进行遍历。 只能获取集合元素，但是不能对集合进行操作。<br>
 * 
 * <pre>
 * 格式：
 * for (数据类型 变量名 : 被遍历的集合(Collection)或者数组) {
 *     // ……
 * }
 * </pre>
 * 
 * 迭代器除了遍历，还可以进行remove的动作。<br>
 * 如果是用LiseIterator,还可以在遍历过程中对集合进行增删改查的动作。<br>
 * 
 * 传统for和增强for有什么区别？<br>
 * 高级for有一个局限性，必须有被遍历的目标。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day17-18-集合(增强for循环)
 */
public class ForEachDemo {

	public static void main(String[] args) {

		ArrayList<String> al = new ArrayList<String>();

		al.add("abc1");
		al.add("abc2");
		al.add("abc3");

		// 高级for循环
		for (String s : al) {
			System.out.println(s);
		}

		// 迭代器
		Iterator<String> it = al.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

		// 传统for循环
		int[] arr = { 3, 5, 1 };
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		for (int i : arr) {
			System.out.println("i = " + i);
		}

		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		hm.put(1, "a");
		hm.put(2, "b");
		hm.put(3, "c");
		Set<Integer> keySet = hm.keySet();
		for (Integer i : keySet) {
			System.out.println(i + " = " + hm.get(i));
		}

		Set<Map.Entry<Integer, String>> entrySet = hm.entrySet();
		for (Map.Entry<Integer, String> me : entrySet) {
			System.out.println(me.getKey() + " = " + me.getValue());
		}

	}

}
