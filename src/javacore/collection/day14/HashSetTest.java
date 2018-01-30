package javacore.collection.day14;

import java.util.HashSet;
import java.util.Iterator;

/**
 * 集合框架(HashSet存储自定义对象)<br>
 * 集合框架(HashSet判断和删除的依据)<br>
 * <p>
 * 往HashSet集合中存入自定义对象。<br>
 * 姓名和年龄相同为同一个人，重复元素。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day14-13-集合框架(HashSet存储自定义对象)
 * @see 传智播客毕向东Java基础视频教程-day14-14-集合框架(HashSet判断和删除的依据)
 */
public class HashSetTest {

	public static void main(String[] args) {
		HashSet<Object> hs = new HashSet<Object>();

		hs.add(new Person1("a1", 11));
		hs.add(new Person1("a2", 12));
		hs.add(new Person1("a3", 13));
		hs.add(new Person1("a4", 14));

		sop(hs.contains(new Person1("a1", 11)));

		hs.remove(new Person1("a4", 14));

		Iterator<Object> it = hs.iterator();
		while (it.hasNext()) {
			Person1 p = (Person1) it.next();
			sop(p.getName() + "::" + p.getAge());
		}
	}

	public static void sop(Object obj) {
		System.out.println(obj);
	}

}

class Person1 {
	private String name;
	private int age;

	Person1(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public int hashCode() {
		return name.hashCode() + age * 37;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Person1)) {
			return false;
		}
		Person1 p = (Person1) obj;
		return this.name.equals(p.name) && this.age == p.age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
}
