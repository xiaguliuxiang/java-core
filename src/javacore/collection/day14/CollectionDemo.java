package javacore.collection.day14;

import java.util.ArrayList;

/**
 * 集合框架(体系概述)<br>
 * 集合框架(共性方法)<br>
 * <p>
 * <ul>
 * <li>1、为什么出现集合类？</li>
 * <dt>面向对象语言对事物的体现都是以对象的形式，所以为了方便对多个对象 的操作，就对对象进行存储，集合就是存储对象最常用的一种方式。</dt>
 * <li>2、数组和集合类同是容器，有何不同？</li>
 * <dt>数组虽然也可以存储对象，但长度是固定的，而集合长度是可变的。</tt>
 * <dt>数组中可以存储基本数据类型，集合只能存储对象。</dt>
 * <li>集合类的特点？</li>
 * <dt>集合只用于存储对象，集合长度是可变的，集合可以存储不同类型的对象。</dt>
 * </ul>
 * <br>
 * 1.add()方法的参数类型是Object,以便于接收任意类型对象。<br>
 * 2.集合中存储的都是对象的引用(地址).<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day14-01-集合框架(体系概述)
 * @see 传智播客毕向东Java基础视频教程-day14-02-集合框架(共性方法)
 */
public class CollectionDemo {

	public static void main(String[] args) {
		// base_method();
		method_2();
	}

	public static void base_method() {
		// 创建一个集合容器，使用Collection接口的子类，ArrayList.
		ArrayList<String> al = new ArrayList<String>();

		// 1.添加元素.
		al.add("java01");
		al.add("java02");
		al.add("java03");
		al.add("java04");

		// 打印集合
		sop(al);

		// 2.获取个数、集合长度。
		sop("al.size() : " + al.size());

		// 3.删除元素。
		al.remove("java02");

		// 打印改变后的集合
		sop(al);

		// 4.判断元素
		sop("java03是否存在:" + al.contains("java03"));
		sop("集合是否为空 : " + al.isEmpty());

		// 清空集合
		al.clear();
	}

	public static void method_2() {
		ArrayList<String> al1 = new ArrayList<String>();
		al1.add("java01");
		al1.add("java02");
		al1.add("java03");
		al1.add("java04");

		ArrayList<String> al2 = new ArrayList<String>();
		al2.add("java03");
		al2.add("java04");
		al2.add("java05");
		al2.add("java06");

		// 取交集，al1中只会保留和al2中相同的元素。
		al1.retainAll(al2);

		sop(al1);
		sop(al2);

		al1.removeAll(al2);
		sop(al1);
		sop(al2);
	}

	public static void sop(Object obj) {
		System.out.println(obj);
	}

}
