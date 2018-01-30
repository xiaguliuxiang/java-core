package javacore.collection.day14;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 集合框架(ArrayList练习)<br>
 * <p>
 * 去除ArrayList集合中的重复元素。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day14-10-集合框架(ArrayList练习)
 */
public class ArrayListTest {

	public static void main(String[] args) {
		ArrayList<Object> al = new ArrayList<Object>();

		al.add("java01");
		al.add("java02");
		al.add("java01");
		al.add("java03");
		al.add("java02");

		sop(al);
		al = singleElement(al);
		sop(al);

		// 在迭代时，循环中next()调用一次，就要hasNext()判断一次.
		try {
			Iterator<Object> it = al.iterator();
			while (it.hasNext()) {
				sop(it.next() + "..." + it.next());
			}
		} catch (NoSuchElementException e) {
			sop("NoSuchElementException");
		}

	}

	public static ArrayList<Object> singleElement(ArrayList<Object> al) {
		// 定义一个临时容器
		ArrayList<Object> newAl = new ArrayList<Object>();

		Iterator<Object> it = al.iterator();

		while (it.hasNext()) {
			Object obj = it.next();
			if (!newAl.contains(obj)) {
				newAl.add(obj);
			}
		}

		return newAl;
	}

	public static void sop(Object obj) {
		System.out.println(obj);
	}

}
