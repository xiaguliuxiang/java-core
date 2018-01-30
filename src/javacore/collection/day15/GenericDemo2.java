package javacore.collection.day15;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * 集合框架(泛型使用)<br>
 * <p>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day15-07-集合框架(泛型使用)
 */
public class GenericDemo2 {

	public static void main(String[] args) {
		TreeSet<String> ts = new TreeSet<String>(new LenComparator());

		ts.add("abcd");
		ts.add("cc");
		ts.add("cba");
		ts.add("aaa");
		ts.add("z");
		ts.add("hahaha");

		Iterator<String> it = ts.iterator();
		while (it.hasNext()) {
			String s = it.next();
			System.out.println(s);
		}
	}

}

class LenComparator implements Comparator<String> {
	@Override
	public int compare(String o1, String o2) {
		int num = new Integer(o1.length()).compareTo(new Integer(o2.length()));

		if (num == 0) {
			return o1.compareTo(o2);
		}
		return num;
	}
}
