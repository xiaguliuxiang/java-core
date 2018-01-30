package javacore.collection.day17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/**
 * 集合(Collections-替换反转)<br>
 * 集合(Collections-reverseOrder)<br>
 * 集合(Collections-SynList)<br>
 * <p>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day17-13-集合(Collections-替换反转)
 * @see 传智播客毕向东Java基础视频教程-day17-14-集合(Collections-reverseOrder)
 * @see 传智播客毕向东Java基础视频教程-day17-15-集合(Collections-SynList)
 */
public class CollectionsDemo2 {
	public static void main(String[] args) {
		fillDemo();
		sop("======");
		replaceAllDemo();
		sop("======");
		orderDemo();
		sop("======");
		shuffleDemo();
	}

	/**
	 * 练习。<br>
	 * fill()方法可以将list集合中所有元素替换成指定元素。<br>
	 * 将list集合中部分元素替换成指定元素。<br>
	 */
	public static void fillDemo() {
		List<String> list = new ArrayList<String>();

		list.add("abcd");
		list.add("aaa");
		list.add("zz");
		list.add("kkkkk");

		sop(list);
		Collections.fill(list, "pp");
		sop(list);
	}

	public static void replaceAllDemo() {
		List<String> list = new ArrayList<String>();

		list.add("abcd");
		list.add("aaa");
		list.add("zz");
		list.add("kkkkk");

		sop(list);
		Collections.replaceAll(list, "aaa", "pp");
		sop(list);
		Collections.reverse(list);
		sop(list);
	}

	public static void orderDemo() {
		TreeSet<String> ts = new TreeSet<String>(Collections.reverseOrder(new StrComparator()));

		ts.add("abcde");
		ts.add("aaa");
		ts.add("kkk");
		ts.add("ccc");

		Iterator<String> it = ts.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

	public static void shuffleDemo() {
		List<String> list = new ArrayList<String>();

		list.add("abcd");
		list.add("aaa");
		list.add("zz");
		list.add("kkkkk");
		list.add("qq");
		list.add("z");

		sop(list);
		Collections.shuffle(list);
		sop(list);
	}

	public static void sop(Object obj) {
		System.out.println(obj);
	}

}

class StrComparator implements Comparator<String> {
	@Override
	public int compare(String s1, String s2) {
		// int num = s1.compareTo(s2);
		// if (num > 0) {
		// return -1;
		// }
		// if (num < 0) {
		// return 1;
		// }
		// return 0;
		return s2.compareTo(s1);
	}
}
