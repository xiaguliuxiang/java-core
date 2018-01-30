package javacore.object_oriented.day05;

/**
 * 面向对象(this关键字)<br>
 * 面向对象(this关键字的应用)<br>
 * <p>
 * this:看上去，是用于区分局部变量和成员变量同名情况。<br>
 * this为什么可以解决这个问题?<br>
 * this到底代表的是什么呢?<br>
 * <br>
 * this:就代表本类的对象，到底代表哪一个呢?<br>
 * this代表它所在函数所属对象的引用。<br>
 * 简单来说：哪个对象在调用this所在的函数，this就代表哪个对象。<br>
 * <br>
 * this的应用：当定义类中功能时，该函数内部要用到调用该函数的对象时，<br>
 * 这时用this来表示这个对象。<br>
 * 但凡本类功能内部使用了本类对象，都用this表示。<br>
 * <br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day05-10-面向对象(this关键字)
 * @see 传智播客毕向东Java基础视频教程-day05-11-面向对象(this关键字的应用)
 */
public class PersonDemo3 {

	public static void main(String[] args) {
		// Person3 p = new Person3("zhangsan", 20);
		// p.speak();

		Person3 p1 = new Person3(20);
		Person3 p2 = new Person3(25);
		boolean b = p1.compare(p2);
		System.out.println(b);

	}

}

class Person3 {
	private String name;
	private int age;

	public Person3(String name) {
		this.name = name;
	}

	public Person3(int age) {
		super();
		this.age = age;
	}

	public Person3(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public void speak() {
		System.out.println("name:" + this.name + ",age:" + this.age);
		this.show();
	}

	public void show() {
		System.out.println(this.name);
	}

	/**
	 * 需求：给人定义一个用于比较年龄是否相同的功能，也就是是否是同龄人。<br>
	 */
	public boolean compare(Person3 p) {
		return this.age == p.age;
	}

}
