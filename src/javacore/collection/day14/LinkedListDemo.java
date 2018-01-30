package javacore.collection.day14;

import java.util.LinkedList;

/**
 * 集合框架(LinkedList)<br>
 * <p>
 * LinkedList:特有方法.<br>
 * addFirst();<br>
 * addLast();<br>
 * <br>
 * getFirst();<br>
 * getLast();<br>
 * 获取元素，但不删除元素。如果集合中没有元素，会出现NoSuchElementException.<br>
 * <br>
 * removeFirst();<br>
 * removeLast();<br>
 * 获取元素，但是元素被删除。如果集合中没有元素，会出现NoSuchElementException.<br>
 * <br>
 * 在JDk1.6出现了替代方法。<br>
 * offerFirst();<br>
 * offerLast();<br>
 * <br>
 * peekFirst();<br>
 * peekLast();<br>
 * 获取元素，但不删除元素。如果集合中没有元素，会返回null.<br>
 * <br>
 * pollFirst();<br>
 * pollLast();<br>
 * 获取元素，但是元素被删除。如果集合中没有元素，会返回null.<br>
 * <br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day14-08-集合框架(LinkedList)
 */
public class LinkedListDemo {

	public static void main(String[] args) {
		LinkedList<String> link = new LinkedList<String>();

		link.addFirst("java01");
		link.addFirst("java02");
		link.addFirst("java03");
		link.addFirst("java04");

		sop(link);

		// sop(link.getFirst());
		// sop(link.getFirst());
		// sop(link.getLast());
		// sop(link.removeFirst());
		// sop(link.removeLast());

		sop("link.size():" + link.size());

		while (!link.isEmpty()) {
			sop(link.removeLast());
		}
	}

	public static void sop(Object obj) {
		System.out.println(obj);
	}

}
