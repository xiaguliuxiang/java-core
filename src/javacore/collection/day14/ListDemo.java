package javacore.collection.day14;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * 集合框架(List集合共性方法)<br>
 * 集合框架(ListIterator)<br>
 * 集合框架(List集合具体对象的特点)<br>
 * <p>
 * 集合框架,为什么会出现这么多的容器呢?<br>
 * 因为每一个容器对数据的存储方式都有不同，这个存储方式称之为：数据结构。<br>
 * <ul>
 * <li>Collection.</li>
 * <dt>List:元素是有序的，元素可以重复，因为该集合体系有索引。</dt>
 * <dd>ArrayList:底层的数据结构使用的数组结构。特点：查询速度很块，但是增删较慢，线程不同步。</dd>
 * <dd>LinkedList:底层的数据结构使用的链表结构。特点：增删速度很快，查询稍慢。</dd>
 * <dd>Vector：底层的数据结构使用的数组结构。线程同步。被ArrayList替代了。</dd>
 * <dd></dd>
 * <dt>Set</dt>
 * <dd>元素是无序的，元素不可以重复。</dd>
 * </ul>
 * List:<br>
 * <dt>特有方法：凡是可以操作角标的方法都是该体系特有的方法。</dt>
 * <dt>增</dt>
 * <dd>add(index, element);</dd>
 * <dd>addAll(index, Collection);</dd>
 * <dt>删</dt>
 * <dd>remove(index);</dd>
 * <dt>改</dt>
 * <dd>set(index, element);</dd>
 * <dt>查</dt>
 * <dd>get(index);</dd>
 * <dd>subList(from, to);</dd>
 * <dd>listIterator();</dd>
 * <p>
 * List集合特有的迭代器。ListIterator是Iterator的子接口。<br>
 * <br>
 * 在迭代时，不可以通过集合对象的方法操作集合中的元素。<br>
 * 因为会发生<code>ConcurrentModificationException</code>异常。<br>
 * 所以，在迭代时，只能用迭代器的方法操作元素，可是Iterator方法是有限的。<br>
 * 只能对元素进行判断，取出，删除的操作。<br>
 * 如果想要其他的操作如添加，修改等，就需要使用其子接口，ListIterator.<br>
 * 该接口只能通过List集合的listIterator()方法获取。<br>
 * <br>
 * ListIterator可以在遍历过程中对集合进行增删改查<br>
 * 正向遍历与逆向遍历<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day14-04-集合框架(List集合共性方法)
 * @see 传智播客毕向东Java基础视频教程-day14-05-集合框架(ListIterator)
 * @see 传智播客毕向东Java基础视频教程-day14-06-集合框架(List集合具体对象的特点)
 */
public class ListDemo {

	public static void main(String[] args) {
		// 演示列表迭代器
		ArrayList<String> al = new ArrayList<String>();

		// 添加元素
		al.add("java01");
		al.add("java02");
		al.add("java03");
		al.add("java04");

		sop(al);

		ListIterator<String> li = al.listIterator();
		while (li.hasNext()) {
			Object obj = li.next();
			if (obj.equals("java02")) {
				li.add("java008");
			}
		}

		sop("hasNext():" + li.hasNext());
		sop("hasPrevious():" + li.hasPrevious());

		while (li.hasPrevious()) {
			sop("pre::" + li.previous());
		}

		sop(al);

		// 在迭代过程中，添加或删除元素。
		Iterator<String> it = al.iterator();
		while (it.hasNext()) {
			Object obj = it.next();
			if (obj.equals("java02")) {
				// 并发修改异常:java.util.ConcurrentModificationException
				// al.add("java008");
				// 将java02的应用从集合中删除了。
				it.remove();
			}
			sop("obj = " + obj);
		}

		sop(al);
	}

	public static void sop(Object obj) {
		System.out.println(obj);
	}

}
