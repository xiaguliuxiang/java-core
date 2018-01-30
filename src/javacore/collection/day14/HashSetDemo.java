package javacore.collection.day14;

import java.util.HashSet;
import java.util.Iterator;

/**
 * 集合框架(HashSet)<br>
 * 集合框架(HashSet存储自定义对象)<br>
 * <p>
 * Set:元素师无序(存入和取出的顺序不一定一致)，元素不可以重复。<br>
 * <p>
 * HashSet:底层数据结构是哈希表。<br>
 * <dt>HashSet是如何保证元素唯一性的呢？</dt>
 * <dd>是通过元素的两个方法，hashCode()和equals()方法来完成。</dd>
 * <dd>如果通过元素的hashCode()值相同，才会判断equals()是否为true.</dd>
 * <dd>如果元素的hashCode()值不同，不会调用equals();</dd>
 * <dd>注意，对于判断元素是否存在，以及删除等操作，依赖的方法是元素的hashCode()方法和equals()方法。</dd>
 * <p>
 * TreeSet<br>
 * <p>
 * Set集合的功能和Collection是一致的。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day14-12-集合框架(HashSet)
 * @see 传智播客毕向东Java基础视频教程-day14-13-集合框架(HashSet存储自定义对象)
 */
public class HashSetDemo {

	public static void main(String[] args) {
		HashSet<Object> hs = new HashSet<Object>();

		hs.add("java01");
		hs.add("java02");
		hs.add("java03");
		hs.add("java04");

		Iterator<Object> it = hs.iterator();
		while (it.hasNext()) {
			sop(it.next());
		}
	}

	public static void sop(Object obj) {
		System.out.println(obj);
	}

}
