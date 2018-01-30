package javacore.collection.day15;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 集合框架(泛型限定)<br>
 * 集合框架(泛型限定2)<br>
 * <p>
 * ?:通配符,也可以理解为占位符。<br>
 * 泛型的限定：<br>
 * ? extend E:可以接收E类型或者E的子类型，上限。<br>
 * ? super E:可以接收E类型或者E的父类型，下限。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day15-12-集合框架(泛型限定)
 * @see 传智播客毕向东Java基础视频教程-day15-13-集合框架(泛型限定2)
 */
public class GenericDemo6 {
	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<String>();

		al.add("abc1");
		al.add("abc2");
		al.add("abc3");

		ArrayList<Integer> al1 = new ArrayList<Integer>();

		al1.add(4);
		al1.add(7);
		al1.add(11);

		printColl(al);
		printColl(al1);

		ArrayList<Person> personList = new ArrayList<Person>();
		personList.add(new Person("abc1"));
		personList.add(new Person("abc2"));
		personList.add(new Person("abc3"));
		printCollPerson(personList);

		ArrayList<Student1> stuList = new ArrayList<Student1>();
		stuList.add(new Student1("stu1"));
		stuList.add(new Student1("stu2"));
		stuList.add(new Student1("stu3"));
		printCollExtend(stuList);

	}

	public static <T> void printColl(ArrayList<T> al) {
		Iterator<T> it = al.iterator();
		while (it.hasNext()) {
			T t = it.next();
			System.out.println(t);
		}
	}

	public static void printCollPerson(ArrayList<Person> al) {
		Iterator<Person> it = al.iterator();
		while (it.hasNext()) {
			Person t = it.next();
			System.out.println(t.getName());
		}
	}

	public static void printCollExtend(ArrayList<? extends Person> al) {
		Iterator<? extends Person> it = al.iterator();
		while (it.hasNext()) {
			Person t = it.next();
			System.out.println(t.getName());
		}
	}

}

class Person {
	private String name;

	Person(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}

class Student1 extends Person {
	Student1(String name) {
		super(name);
	}
}
