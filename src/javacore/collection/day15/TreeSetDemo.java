package javacore.collection.day15;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * 集合框架(TreeSet)<br>
 * <p>
 * Set:无序，不可以重复元素。<br>
 * HashSet:数据结构是哈希表，线程时非同步的。<br>
 * 保证元素唯一性的原理：判断元素的hashCode()是否相同。<br>
 * 如果相同，还会继续判断元素的equals()方法，是否为true.<br>
 * <br>
 * TreeSet:可以读Set集合中的元素进行排序。<br>
 * <p>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day15-01-集合框架(TreeSet)
 */
public class TreeSetDemo {

	public static void main(String[] args) {
		TreeSet<String> ts = new TreeSet<String>();

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
