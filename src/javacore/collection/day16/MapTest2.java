package javacore.collection.day16;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * 集合(TreeMap练习)<br>
 * <p>
 * 需求：对学生对象的年龄进行升序排序。<br>
 * 因为数据是以键值对形式存在的。<br>
 * 所以要使用可以排序的Map集合，TreeMap.<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day16-07-集合(TreeMap练习)
 */
public class MapTest2 {
	public static void main(String[] args) {
		TreeMap<Student2, String> tm = new TreeMap<Student2, String>(new StuNameComparator());

		tm.put(new Student2("lisi3", 23), "nanjing");
		tm.put(new Student2("lisi1", 21), "beijing");
		tm.put(new Student2("lisi4", 24), "wuhan");
		tm.put(new Student2("lisi2", 22), "shanghai");

		Set<Map.Entry<Student2, String>> entrySet = tm.entrySet();
		Iterator<Map.Entry<Student2, String>> it = entrySet.iterator();
		while (it.hasNext()) {
			Map.Entry<Student2, String> me = it.next();
			Student2 stu = me.getKey();
			String addr = me.getValue();
			System.out.println(stu + "..." + addr);
		}
	}
}

class StuNameComparator implements Comparator<Student2> {
	@Override
	public int compare(Student2 s1, Student2 s2) {
		int num = s1.getName().compareTo(s2.getName());
		if (num == 0) {
			return new Integer(s1.getAge()).compareTo(new Integer(s2.getAge()));
		}
		return num;
	}
}

class Student2 implements Comparable<Student2> {
	private String name;
	private int age;

	Student2(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public int hashCode() {
		return name.hashCode() + age * 34;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Student2)) {
			throw new ClassCastException("类型不匹配");
		}
		Student2 stu = (Student2) obj;
		return this.name.equals(stu.name) && this.age == stu.age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String toString() {
		return name + ":" + age;
	}

	@Override
	public int compareTo(Student2 s) {
		int num = new Integer(this.age).compareTo(new Integer(s.age));

		if (num == 0) {
			return this.name.compareTo(s.name);
		}
		return num;
	}

}
