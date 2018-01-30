package javacore.collection.day15;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 集合框架(泛型概述)<br>
 * 集合框架(泛型使用)<br>
 * <p>
 * 泛型：JDK1.5版本以后出现的新特性，用于解决安全问题，是一个类型安全机制。<br>
 * <br>
 * 好处：<br>
 * 1.将运行时期出现的问题ClassCastException，转移到了编译时期。<br>
 * 方便与程序员解决问题，让运行时期问题减少，安全。<br>
 * 2.避免了强制转换麻烦。<br>
 * <p>
 * 泛型格式：通过<>来定义要操作的引用数据类型。<br>
 * 在使用java提供的对象时，什么时候写泛型呢?<br>
 * 通常在集合框架中很常见。<br>
 * 只要见到<>就要定义泛型。<br>
 * <br>
 * 其实<>就是用来接收类型的。<br>
 * 当使用集合时，将集合中要存储的数据类型作为参数传递到<>中即可。<br>
 * <br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day15-06-集合框架(泛型概述)
 * @see 传智播客毕向东Java基础视频教程-day15-07-集合框架(泛型使用)
 */
public class GenericDemo {

	public static void main(String[] args) {
		ArrayList<Object> al = new ArrayList<Object>();

		al.add("abc01");
		al.add("abc0991");
		al.add("abc014");

		// al.add(4);

		Iterator<Object> it = al.iterator();
		while (it.hasNext()) {
			String s = (String) it.next();
			System.out.println(s + ":" + s.length());
		}

	}

}
