package javacore.collection.day15;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * 集合框架(实现Comparator方式排序)<br>
 * <p>
 * 当元素自身不具备比较性，或者具备的比较性不是所需要的。<br>
 * 这时需要让容器自身具备比较性。<br>
 * 定义了比较器，将比较器对象作为参数传递给TreeSet集合的构造函数。<br>
 * <br>
 * 当两种排序都存在时，以比较器为主。<br>
 * <br>
 * 定义一个类，实现Comparetor接口，覆盖compare()方法。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day15-04-集合框架(实现Comparator方式排序)
 */
public class TreeSetDemo3 {
	public static void main(String[] args) {
		TreeSet<Object> ts = new TreeSet<Object>(new MyCompare());

		ts.add(new Student3("lisi02", 22));
		ts.add(new Student3("lisi007", 27));
		ts.add(new Student3("lisi09", 25));
		ts.add(new Student3("lisi01", 25));

		Iterator<Object> it = ts.iterator();
		while (it.hasNext()) {
			Student3 stu = (Student3) it.next();
			System.out.println(stu.getName() + "..." + stu.getAge());
		}
	}
}

class MyCompare implements Comparator<Object> {

	@Override
	public int compare(Object o1, Object o2) {
		Student3 s1 = (Student3) o1;
		Student3 s2 = (Student3) o2;
		int num = s1.getName().compareTo(s2.getName());
		if (num == 0) {
			return new Integer(s1.getAge()).compareTo(new Integer(s2.getAge()));
			// if (s1.getAge() > s2.getAge()) {
			// return 1;
			// }
			// if (s1.getAge() == s2.getAge()) {
			// return 0;
			// }
			// return -1;
		}
		return num;
	}

}

class Student3 implements Comparable<Object> {
	private String name;
	private int age;

	Student3(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public int compareTo(Object obj) {
		if (!(obj instanceof Student3)) {
			throw new RuntimeException("不是学生对象");
		}
		Student3 s = (Student3) obj;
		System.out.println(this.name + "...compareto..." + s.name);
		if (this.age > s.age) {
			return 1;
		}
		if (this.age == s.age) {
			return this.name.compareTo(s.name);
		}
		return -1;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
}
