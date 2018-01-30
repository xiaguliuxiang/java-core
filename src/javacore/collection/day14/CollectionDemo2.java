package javacore.collection.day14;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 集合框架(迭代器)<br>
 * <p>
 * 什么是迭代器呢?<br>
 * 其实就是集合的取出元素的方式。<br>
 * <br>
 * 把取出方式定义在集合的内部，这样取出方式就可以直接访问集合内部的元素。<br>
 * 那么取出方式就被定义成了内部类。<br>
 * 而每一个容器的数据结构不同，所以取出的动作细节也不一样。<br>
 * 但是都有共性内容，判断和取出。<br>
 * 那么可以将这些共性抽取。<br>
 * <br>
 * 那么这些内部类都符合一个规则，该规则是Iterator.<br>
 * 如何获取集合的取出对象呢?<br>
 * 通过一个对外提供的方法:iterator();<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day14-03-集合框架(迭代器)
 */
public class CollectionDemo2 {

	public static void main(String[] args) {
		method();
	}

	public static void method() {
		// 创建一个集合容器，使用Collection接口的子类，ArrayList.
		ArrayList<String> al = new ArrayList<String>();

		// 1.添加元素.
		al.add("java01");
		al.add("java02");
		al.add("java03");
		al.add("java04");

		// 获取迭代器,用于取出集合中的元素.
		Iterator<String> it = al.iterator();
		while (it.hasNext()) {
			sop(it.next());
		}

		sop("======");

		for (Iterator<String> i = al.iterator(); i.hasNext();) {
			sop(i.next());
		}

	}

	public static void sop(Object obj) {
		System.out.println(obj);
	}

}
