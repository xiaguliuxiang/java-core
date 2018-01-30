package javacore.io.day21;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * IO流(对象的序列化)<br>
 * <p>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day21-01-IO流(对象的序列化)
 */
public class ObjectStreamDemo {

	public static void main(String[] args) throws Exception {
		writeObj();
		readObj();
	}

	public static void readObj() throws Exception {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("file" + File.separator + "person.object"));

		Person p = (Person) ois.readObject();

		System.out.println(p);

		ois.close();
	}

	public static void writeObj() throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream("file" + File.separator + "person.object"));

		oos.writeObject(new Person("zhangsan", 39, "kr"));

		oos.close();
	}

}

class Person implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	// transient 修饰：不能被序列化，保证值在堆内存中存在，而不再文本文件中存在。
	private transient int age;
	private static String country = "cn";

	@SuppressWarnings("static-access")
	public Person(String name, int age, String country) {
		super();
		this.name = name;
		this.age = age;
		this.country = country;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", country=" + country + "]";
	}
}
