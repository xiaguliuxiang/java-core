package javacore.collection.day15;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * 集合框架(TreeSet)<br>
 * 集合框架(TreeSet存储自定义对象)<br>
 * 集合框架(二叉树)<br>
 * 集合框架(实现Comparator方式排序)<br>
 * <p>
 * Set:无序，不可以重复元素。<br>
 * HashSet:数据结构是哈希表，线程时非同步的。<br>
 * 保证元素唯一性的原理：判断元素的hashCode()是否相同。<br>
 * 如果相同，还会继续判断元素的equals()方法，是否为true.<br>
 * <br>
 * TreeSet:可以读Set集合中的元素进行排序。<br>
 * 底层数据结构是二叉树。<br>
 * 保证元素唯一性的依据：compareTo()方法return 0;<br>
 * TreeSet排序的第一种方式：<br>
 * 让元素自身具备比较性，元素需要实现Comparable接口，覆盖compareTo()方法。<br>
 * 这种方式也称为元素的自然顺序，或者叫做默认顺序。<br>
 * TreeSet的第二种艾旭方式：<br>
 * 当元素自身不具备比较性时，或者具备的比较性不是所需要的。<br>
 * 这时就需要让集合自身具备比较性。<br>
 * 在集合初始化时，就有了比较方式。<br>
 * <p>
 * 需求：往TreeSet集合中存储自定义对象学生。<br>
 * 想按照学生的年龄进行排序。<br>
 * <br>
 * 记住，排序时，当主要条件相同时，一定要判断以下次要条件。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day15-01-集合框架(TreeSet)
 * @see 传智播客毕向东Java基础视频教程-day15-02-集合框架(TreeSet存储自定义对象)
 * @see 传智播客毕向东Java基础视频教程-day15-03-集合框架(二叉树)
 * @see 传智播客毕向东Java基础视频教程-day15-04-集合框架(实现Comparator方式排序)
 */
public class TreeSetDemo2 {

	public static void main(String[] args) {
		TreeSet<Object> ts = new TreeSet<Object>();

		ts.add(new Student("lisi02", 22));
		ts.add(new Student("lisi007", 27));
		ts.add(new Student("lisi09", 25));
		ts.add(new Student("lisi01", 25));

		Iterator<Object> it = ts.iterator();
		while (it.hasNext()) {
			Student stu = (Student) it.next();
			System.out.println(stu.getName() + "..." + stu.getAge());
		}
	}

}

class Student implements Comparable<Object> {
	private String name;
	private int age;

	Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public int compareTo(Object obj) {
		return 1;
		// if (!(obj instanceof Student)) {
		// throw new RuntimeException("不是学生对象");
		// }
		// Student s = (Student) obj;
		// System.out.println(this.name + "...compareto..." + s.name);
		// if (this.age > s.age) {
		// return 1;
		// }
		// if (this.age == s.age) {
		// return this.name.compareTo(s.name);
		// }
		// return -1;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
}
