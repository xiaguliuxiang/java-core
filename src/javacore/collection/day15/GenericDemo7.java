package javacore.collection.day15;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * 集合框架(泛型限定2)<br>
 * <p>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day15-13-集合框架(泛型限定2)
 */
public class GenericDemo7 {
	public static void main(String[] args) {
		TreeSet<Student7> ts = new TreeSet<Student7>(new StuComp());
		ts.add(new Student7("abc1"));
		ts.add(new Student7("abc2"));
		ts.add(new Student7("abc3"));
		ts.add(new Student7("abc4"));

		Iterator<Student7> it = ts.iterator();
		while (it.hasNext()) {
			Student7 stu = (Student7) it.next();
			System.out.println(stu.getName());
		}

		TreeSet<Student7> ts1 = new TreeSet<Student7>(new Comp());
		ts1.add(new Student7("abcd1"));
		ts1.add(new Student7("abcd2"));
		ts1.add(new Student7("abcd3"));
		ts1.add(new Student7("abcd4"));

		Iterator<Student7> it1 = ts1.iterator();
		while (it1.hasNext()) {
			Student7 stu = (Student7) it1.next();
			System.out.println(stu.getName());
		}
	}
}

class Person7 {
	private String name;

	Person7(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}

class Student7 extends Person7 {
	Student7(String name) {
		super(name);
	}
}

class Comp implements Comparator<Person7> {
	@Override
	public int compare(Person7 p1, Person7 p2) {
		return p1.getName().compareTo(p2.getName());
	}
}

class StuComp implements Comparator<Student7> {
	@Override
	public int compare(Student7 s1, Student7 s2) {
		return s1.getName().compareTo(s2.getName());
	}
}