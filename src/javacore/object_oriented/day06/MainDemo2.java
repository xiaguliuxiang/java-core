package javacore.object_oriented.day06;

/**
 * 面向对象(静态什么时候使用)<br>
 * <p>
 * 什么时候使用静态？<br>
 * 要从两方面下手：<br>
 * 因为静态修饰的内容有成员变量和函数。<br>
 * 什么时候定义静态变量(类变量)呢？<br>
 * 当对象中出现共享数据时，该数据被静态所修饰。<br>
 * 对象中的特有数据要定义成非静态存在于堆内存中。<br>
 * <br>
 * 什么时候定义静态函数呢？<br>
 * 当功能内部没有访问到非静态数据(对象的特有数据)。<br>
 * 那么该功能可以定义成静态的。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day06-03-面向对象(静态什么时候使用)
 */
public class MainDemo2 {

	public static void main(String[] args) {
		Person p = new Person();
		p.show();

		Person.speak();
	}

}

class Person {
	String name;

	public void show() {
		System.out.println("show");
	}

	public static void speak() {
		System.out.println("speak");
	}
}
