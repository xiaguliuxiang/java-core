package javacore.collection.day15;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * 集合框架(TreeSet练习)<br>
 * <p>
 * 练习：按照字符串长度排序。<br>
 * 字符串本身具备比较性，但是它的比较方式不是所需要的。<br>
 * 这时就只能使用比较器。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day15-05-集合框架(TreeSet练习)
 */
public class TreeSetTest {
	public static void main(String[] args) {
		TreeSet<String> ts = new TreeSet<String>(new StrLenComparator());

		ts.add("cc");
		ts.add("cba");
		ts.add("abcd");
		ts.add("aaa");
		ts.add("bca");

		Iterator<String> it = ts.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}

class StrLenComparator implements Comparator<Object> {
	@Override
	public int compare(Object o1, Object o2) {
		String s1 = (String) o1;
		String s2 = (String) o2;

		int num = new Integer(s1.length()).compareTo(new Integer(s2.length()));
		if (num == 0) {
			return s1.compareTo(s2);
		}
		return num;

		// if (s1.length() > s2.length()) {
		// return 1;
		// }
		// if (s1.length() == s2.length()) {
		// return 0;
		// }
		// return -1;
	}
}
