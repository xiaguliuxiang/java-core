package javacore.collection.day14;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 集合框架(ArrayList练习2)<br>
 * <p>
 * 将自定义对象作为元素存到ArrayList集合中，并取出重复元素。<br>
 * 比如：有人对象。同姓名同年龄，视为同一个人，为重复元素。<br>
 * <br>
 * 思路：<br>
 * 1.对人描述，将数据封装进人对象。<br>
 * 2.定义容器，将人存入。<br>
 * 3.取出。<br>
 * <br>
 * List集合判断元素是否相同，依据是元素的equals()方法。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day14-11-集合框架(ArrayList练习2)
 */
public class ArrayList2 {

	public static void main(String[] args) {
		ArrayList<Object> al = new ArrayList<Object>();

		al.add(new Person1("lisi01", 21));
		al.add(new Person1("lisi02", 22));
		al.add(new Person1("lisi03", 23));
		al.add(new Person1("lisi02", 22));
		al.add(new Person1("lisi02", 32));
		al.add(new Person1("lisi04", 24));

		al = singleElement(al);

		sop("remove:" + al.remove(new Person1("lisi03", 23)));

		Iterator<Object> it = al.iterator();
		while (it.hasNext()) {
			Person1 p = (Person1) it.next();
			sop(p.getName() + "::" + p.getAge());
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

class Person {
	private String name;
	private int age;

	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Person)) {
			return false;
		}
		Person p = (Person) obj;
		return this.name.equals(p.name) && this.age == p.age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
}
