package javacore.collection.day16;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 集合(Map练习)<br>
 * <p>
 * 么一个学生都有对应的归属地。<br>
 * 学生Student,地址String.<br>
 * 学生属性：姓名，年龄。<br>
 * 注意：姓名和年龄相同的视为同一个学生。<br>
 * 保证学生的唯一性。<br>
 * <p>
 * 1.描述学生。<br>
 * 2.定义Map容器，将学生作为键，地址作为值，存入。<br>
 * 3.获取Map集合中的元素。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day16-06-集合(Map练习)
 */
public class MapTest {
	public static void main(String[] args) {
		HashMap<Student, String> hm = new HashMap<Student, String>();

		hm.put(new Student("lisi1", 21), "beijing");
		hm.put(new Student("lisi2", 22), "shanghai");
		hm.put(new Student("lisi3", 23), "guangzhou");
		hm.put(new Student("lisi4", 24), "shenzhen");

		// 第一种取出方式 keySet
		Set<Student> keySet = hm.keySet();
		Iterator<Student> it = keySet.iterator();
		while (it.hasNext()) {
			Student stu = it.next();
			String addr = hm.get(stu);
			System.out.println(stu + "..." + addr);
		}

		// 第二种取出方式 entrySet
		Set<Map.Entry<Student, String>> entrySet = hm.entrySet();
		Iterator<Map.Entry<Student, String>> iter = entrySet.iterator();
		while (iter.hasNext()) {
			Map.Entry<Student, String> me = iter.next();
			Student stu = me.getKey();
			String addr = me.getValue();
			System.out.println(stu + "..." + addr);
		}
	}
}

class Student implements Comparable<Student> {
	private String name;
	private int age;

	Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public int hashCode() {
		return name.hashCode() + age * 34;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Student)) {
			throw new ClassCastException("类型不匹配");
		}
		Student stu = (Student) obj;
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
	public int compareTo(Student s) {
		int num = new Integer(this.age).compareTo(new Integer(s.age));

		if (num == 0) {
			return this.name.compareTo(s.name);
		}
		return num;
	}

}
